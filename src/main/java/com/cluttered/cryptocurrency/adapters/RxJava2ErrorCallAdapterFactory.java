package com.cluttered.cryptocurrency.adapters;

import com.cluttered.cryptocurrency.exceptions.BittrexException;
import com.cluttered.cryptocurrency.model.ApiResponse;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class RxJava2ErrorCallAdapterFactory extends CallAdapter.Factory {

    private final RxJava2CallAdapterFactory original;

    private RxJava2ErrorCallAdapterFactory() {
        original = RxJava2CallAdapterFactory.create();
    }

    public static CallAdapter.Factory create() {
        return new RxJava2ErrorCallAdapterFactory();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public CallAdapter get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        return new RxCallAdapterWrapper(original.get(returnType, annotations, retrofit));
    }

    private static class RxCallAdapterWrapper implements CallAdapter<Object, Observable<ApiResponse<?>>> {
        private final CallAdapter wrapped;

        public RxCallAdapterWrapper(final CallAdapter wrapped) {
            this.wrapped = wrapped;
        }

        @Override
        public Type responseType() {
            return wrapped.responseType();
        }

        @SuppressWarnings({"unchecked", "NullableProblems"})
        @Override
        public Observable<ApiResponse<?>> adapt(final Call call) {
            final Observable<ApiResponse<?>> adaptedCall = (Observable<ApiResponse<?>>) wrapped.adapt(call);

            return adaptedCall.doOnNext(apiResponse -> {
                if (!apiResponse.getSuccess()) {
                    throw new BittrexException(apiResponse.getMessage());
                }
            });
        }
    }
}

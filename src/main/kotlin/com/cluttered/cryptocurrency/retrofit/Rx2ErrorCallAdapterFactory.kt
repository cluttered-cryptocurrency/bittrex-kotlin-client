package com.cluttered.cryptocurrency.retrofit

import com.cluttered.cryptocurrency.model.ApiResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.lang.reflect.Type

object Rx2ErrorCallAdapterFactory : CallAdapter.Factory() {

    private val original = RxJava2CallAdapterFactory.create()

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *> {
        return RxCallAdapterWrapper(original.get(returnType, annotations, retrofit)!! as CallAdapter<Any, Any>)
    }

    private class RxCallAdapterWrapper(private val wrapped: CallAdapter<Any, Any>) : CallAdapter<Any, Observable<ApiResponse<Any>>> {

        override fun responseType(): Type {
            return wrapped.responseType()
        }

        override fun adapt(call: Call<Any>): Observable<ApiResponse<Any>> {
            val adaptedCall = wrapped.adapt(call) as Observable<ApiResponse<Any>>
            return adaptedCall.doOnNext {
                if (!it.success) {
                    throw BittrexException(it.message)
                }
            }
        }
    }
}
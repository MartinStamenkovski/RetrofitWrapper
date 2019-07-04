package com.martin.retrofitwrapper.retrofit

/**
 * Created by martin on 2/7/18.
 */

class RW private constructor() {

    companion object {
        @JvmStatic
        @get:JvmName("request")
        val request: RetrofitInterface = RetrofitBuilder.getRetrofitInterface()
    }
}

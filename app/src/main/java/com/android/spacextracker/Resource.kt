package com.android.spacextracker

sealed class Resource<T>(
    val data: T?=null,
    val message: String?=null,
    val code: Int=0
){
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: String,code:Int=0,data:T?=null): Resource<T>(data,message,code)
    class Loading<T>(data: T?=null): Resource<T>(data)

}
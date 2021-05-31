package com.example.harajtask

sealed class Failure(msg: String = "Error occurred!") : Exception(msg) {
    abstract class DataFailure(msg: String = "Data error occurred!") : Failure(msg)
}
package com.example.propagation

import org.springframework.stereotype.Service

@Service
class SampleService(
    private val customProducer: CustomProducer
) {

    fun send(userInfo: CustomProducer.UserInfo) {
        customProducer.send(userInfo)
    }

    fun send(otherInfo: CustomProducer.OtherUserInfo) {
        customProducer.send(otherInfo)
    }

}
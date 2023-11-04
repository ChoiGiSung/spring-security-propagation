package com.example.propagation

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KafkaProducerTest {

	@Autowired
	lateinit var service: SampleService

	@Test
	fun something() {
		service.send(CustomProducer.UserInfo("홍길동", "010-1234-5678", "홍홍"))
	}

	@Test
	fun something2() {
		service.send(CustomProducer.OtherUserInfo("홍길동", 12))
	}

}

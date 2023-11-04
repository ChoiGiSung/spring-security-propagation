package com.example.propagation

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.context.support.WithMockUser

@SpringBootTest
class KafkaProducerTest {

	@Autowired
	lateinit var service: SampleService

	@Test
	@WithMockUser
	fun something() {
		service.send(CustomProducer.UserInfo("홍길동", "010-1234-5678", "홍홍"))
	}

	@Test
	@WithMockUser
	fun something2() {
		service.send(CustomProducer.OtherUserInfo("홍길동", 12))
	}

}

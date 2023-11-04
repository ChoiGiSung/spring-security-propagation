package com.example.propagation

import org.apache.kafka.clients.producer.ProducerInterceptor
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import org.springframework.security.core.context.SecurityContextHolder
import java.lang.Exception

class KafkaRecordInterceptor: ProducerInterceptor<String, Any> {
    override fun configure(configs: MutableMap<String, *>?) {
        // 프로듀서 구성을 설정하려면 사용할 수 있습니다.
    }

    override fun onAcknowledgement(metadata: RecordMetadata?, exception: Exception?) {
        // 전송 확인이나 오류 처리를 수행할 수 있습니다.
    }

    override fun close() {
        // 레코드 인터셉터를 닫을 때 수행해야 할 작업을 정의합니다.
    }

    override fun onSend(record: ProducerRecord<String, Any>): ProducerRecord<String, Any> {
        // 레코드를 변경하여 SecurityContext에서 추출한 정보를 레코드 헤더에 추가합니다.
        val authentication = SecurityContextHolder.getContext().authentication
        record.headers().add("custom-authorization-header", authentication.name.toByteArray())
        return record
    }
}
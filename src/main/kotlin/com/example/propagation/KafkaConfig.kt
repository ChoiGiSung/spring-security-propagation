package com.example.propagation

import org.apache.kafka.clients.producer.ProducerConfig
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory

@Configuration
class KafkaConfig : DefaultKafkaProducerFactoryCustomizer {

    override fun customize(producerFactory: DefaultKafkaProducerFactory<*, *>) {
        val producerProperties: MutableMap<String, Any> = mutableMapOf()
        producerProperties[ProducerConfig.INTERCEPTOR_CLASSES_CONFIG] = KafkaRecordInterceptor::class.java.name
        producerFactory.updateConfigs(producerProperties)
    }
}
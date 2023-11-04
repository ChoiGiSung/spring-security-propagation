package com.example.propagation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor

@Configuration
@EnableAsync
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun threadPoolTaskExecutor(): ThreadPoolTaskExecutor? {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 10
        executor.maxPoolSize = 100
        executor.queueCapacity = 50
        executor.setThreadNamePrefix("async-")
        return executor
    }

    @Bean
    fun taskExecutor(threadPoolTaskExecutor: ThreadPoolTaskExecutor): DelegatingSecurityContextAsyncTaskExecutor {
        return DelegatingSecurityContextAsyncTaskExecutor(threadPoolTaskExecutor)
    }
}
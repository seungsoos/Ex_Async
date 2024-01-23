package org.dummy.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AppConfig {

    @Bean("async-thread")
    public Executor asyncThread() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(100);         // 최대가 100개
        threadPoolTaskExecutor.setCorePoolSize(10);         // 기본 10개 시작
        threadPoolTaskExecutor.setQueueCapacity(10);        // CorePoolsize을 다 사용시 10개 추가
        threadPoolTaskExecutor.setThreadNamePrefix("Async-");
        return threadPoolTaskExecutor;
    }
}

package com.chat.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class ChatConfig {
    @Bean(name = "chatThreadPool")
    public Executor chatThreadPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);  // Minimum number of threads
        executor.setMaxPoolSize(50);   // Maximum number of threads
        executor.setQueueCapacity(100); // Capacity of the queue
        executor.setThreadNamePrefix("ChatThread-"); // Naming threads for easier debugging
        executor.initialize();
        return executor;
    }
}

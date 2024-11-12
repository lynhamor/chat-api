package com.chat.api.service;

import com.chat.api.dto.ChatDto;
import com.chat.api.dto.ResultDto;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ChatService {

    @Async("chatThreadPool")
    public CompletableFuture<ResultDto> join(ChatDto dto){

        ResultDto result = new ResultDto();
        result.setCode("2000");
        result.setData(dto);
        result.setResult("SUCCESS");

        return CompletableFuture.completedFuture(result);
    }
}

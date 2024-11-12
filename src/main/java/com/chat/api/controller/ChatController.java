package com.chat.api.controller;

import com.chat.api.dto.ChatDto;
import com.chat.api.dto.ResultDto;
import com.chat.api.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService service;

    @PostMapping("/join")
    public ResultDto join(@RequestBody ChatDto dto) {
        try {
            return service.join(dto).get(); // Blocks until result is available
        } catch (InterruptedException | ExecutionException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to join chat", e);
        }
    }

    @PostMapping("/joins")
    public CompletableFuture<ResultDto> joinChat(@RequestBody ChatDto dto) {
        return service.join(dto); // Non-blocking
    }
}

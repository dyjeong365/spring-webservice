package com.jojoldu.webservice.web;

import com.jojoldu.webservice.domain.posts.PostsRepository;
import com.jojoldu.webservice.dto.posts.PostsSaveRequestDto;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebRestController {
    private final PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "who are you";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }
}

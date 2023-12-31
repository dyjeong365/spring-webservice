package com.jojoldu.webservice.service;

import com.jojoldu.webservice.domain.posts.PostsRepository;
import com.jojoldu.webservice.dto.posts.PostsMainResponseDto;
import com.jojoldu.webservice.dto.posts.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .stream()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}

package com.jojoldu.webservice.service;

import com.jojoldu.webservice.domain.posts.Posts;
import com.jojoldu.webservice.domain.posts.PostsRepository;
import com.jojoldu.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    void save() {
        //given
        PostsSaveRequestDto dto = new PostsSaveRequestDto().builder()
                .author("hgd@gmail.com")
                .content("hgd")
                .title("gdh")
                .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor(), is(equalTo("hgd@gmail.com")));
        assertThat(posts.getContent(), is(equalTo("hgd")));
        assertThat(posts.getTitle(), is(equalTo("gdh")));
    }
}

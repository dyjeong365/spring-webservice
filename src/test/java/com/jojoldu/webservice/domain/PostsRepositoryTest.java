package com.jojoldu.webservice.domain;

import com.jojoldu.webservice.domain.posts.Posts;
import com.jojoldu.webservice.domain.posts.PostsRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    void save_and_load() {
        //given
        postsRepository.save(Posts.builder()
                .title("test title")
                .content("test content")
                .author("test@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is(equalTo("test title")));
        assertThat(posts.getContent(), is(equalTo("test content")));
        assertThat(posts.getAuthor(), is(equalTo("test@gmail.com")));
    }

    @Test
    void BaseTimeEntity_register() {
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("test title")
                .content("test content")
                .author("test@gmail.com")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getCreatedDate(), is(Matchers.greaterThan(now)));
        assertThat(posts.getModifiedDate(), is(Matchers.greaterThan(now)));
    }
}

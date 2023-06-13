package com.jojoldu.webservice.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void mainpage_loading() {
        //when
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        assertThat(body, containsString("스프링부트로 시작하는 웹 서비스"));
    }
}

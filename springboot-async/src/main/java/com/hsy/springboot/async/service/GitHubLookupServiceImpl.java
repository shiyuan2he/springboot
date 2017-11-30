package com.hsy.springboot.async.service;

import com.hsy.springboot.async.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service(value = "githubLookupService")
public class GitHubLookupServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(GitHubLookupServiceImpl.class);

    private final RestTemplate restTemplate;

    public GitHubLookupServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public Future<User> findUser(String user) throws InterruptedException {
        logger.info("Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        User results = restTemplate.getForObject(url, User.class);
        Thread.sleep(1000L);
        return new AsyncResult<>(results);
    }
}

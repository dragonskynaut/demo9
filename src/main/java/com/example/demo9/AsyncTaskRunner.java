package com.example.demo9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AsyncTaskRunner implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncTaskRunner.class);
    @Autowired
    private MyLongJobService service;

    @Override
    public void run(String... args) throws Exception {
        CompletableFuture<String> result1 = service.doLong(5);
        LOGGER.info("do1");
        CompletableFuture<String> result2 = service.doLong(10);
        LOGGER.info("do2");
        CompletableFuture<String> result3 = service.doLong(15);
        CompletableFuture.allOf(result1, result2, result3).join();
        LOGGER.info("do3");
        LOGGER.info("result1 result="+ result1.get());
        LOGGER.info("get1");
        LOGGER.info("result1 result="+ result2.get());
        LOGGER.info("get2");
        LOGGER.info("result1 result="+ result3.get());
        LOGGER.info("doAll");
    }
}

package com.example.demo9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service //compare to component it lives more times
public class MyLongJobService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyLongJobService.class);

    @Async
    public void doLong2(int y) throws InterruptedException{
        LOGGER.info("start to do long");
        Thread.sleep(y * 1000);
        LOGGER.info("long job finish, will return");
    }
}

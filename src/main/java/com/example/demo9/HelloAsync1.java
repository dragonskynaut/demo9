package com.example.demo9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloAsync1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloAsync1.class);
    @Autowired
    private MyLongJobService service;

    @RequestMapping("/hello2")
    public String hello2(){
        LOGGER.info("start hello2");
        try{
            service.doLong2(10);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        LOGGER.info("return hello2");
        return "finish";
    }
}

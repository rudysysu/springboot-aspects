package com.github.rudysysu.springboot.aspects;

import com.github.rudysysu.springboot.aspects.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class Main implements ApplicationListener<ApplicationReadyEvent> {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    private MyService service;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        service.doQuery();
        service.doUpdate();
    }
}

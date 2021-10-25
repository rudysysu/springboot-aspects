package com.dy.springboot.aop.service;

import com.dy.springboot.aop.annotation.DataSourceChange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyService {
    private static final Logger LOG = LoggerFactory.getLogger(MyService.class);

    @DataSourceChange(slave = true)
    public void doQuery() {
        LOG.warn("doQuery");
    }

    @DataSourceChange(slave = false)
    public void doUpdate() {
        LOG.warn("doUpdate");
    }
}

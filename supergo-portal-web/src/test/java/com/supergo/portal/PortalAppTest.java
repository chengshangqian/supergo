package com.supergo.portal;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PortalAppTest {

    // 打印日志
    private static final Logger LOGGER = LoggerFactory.getLogger(PortalAppTest.class);

    @Test
    void contextLoad(){
        LOGGER.debug("暂时测试用例...");
    }
}
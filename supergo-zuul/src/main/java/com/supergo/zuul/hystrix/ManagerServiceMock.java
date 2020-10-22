package com.supergo.zuul.hystrix;

import org.springframework.stereotype.Component;

@Component
public class ManagerServiceMock extends AbstractServiceMock {
    @Override
    public String route() {
        return "supergo-manager-web";
    }
}

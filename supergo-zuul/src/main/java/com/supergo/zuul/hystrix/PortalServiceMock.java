package com.supergo.zuul.hystrix;

import org.springframework.stereotype.Component;

@Component
public class PortalServiceMock extends AbstractServiceMock {
    @Override
    public String route() {
        return "supergo-portal-web";
    }
}

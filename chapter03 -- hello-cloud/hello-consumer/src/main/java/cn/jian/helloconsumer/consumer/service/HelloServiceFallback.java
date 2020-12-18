package cn.jian.helloconsumer.consumer.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloService {
    public String hello(String name) {
        return "Hello, " + name + ", I'm fallback!";
    }
}

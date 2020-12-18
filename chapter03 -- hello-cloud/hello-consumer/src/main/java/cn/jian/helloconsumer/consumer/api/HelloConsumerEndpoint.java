package cn.jian.helloconsumer.consumer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.jian.helloconsumer.consumer.service.HelloService;



@RestController
@RequestMapping("/hello")
public class HelloConsumerEndpoint {
    @Autowired
    private HelloService helloService;

    @GetMapping("/{name}")
    public String hello(@PathVariable String name){
        return this.helloService.hello(name);
    }
}

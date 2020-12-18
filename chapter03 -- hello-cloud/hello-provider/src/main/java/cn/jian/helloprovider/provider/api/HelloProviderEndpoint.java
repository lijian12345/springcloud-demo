package cn.jian.helloprovider.provider.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloProviderEndpoint {
    @GetMapping("/{name}")
    public String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
}

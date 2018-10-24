package cn.tpson.demo.springbootdubbo.consumer.controller;

import cn.tpson.demo.springbootdubbo.api.service.DemoService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zhangka in 2018/10/23
 */
@RestController
public class DemoConsumerController {

    @Reference
    private DemoService demoService;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        return demoService.sayHello(name);
    }

}

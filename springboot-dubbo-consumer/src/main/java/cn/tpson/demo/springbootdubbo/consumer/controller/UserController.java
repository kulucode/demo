package cn.tpson.demo.springbootdubbo.consumer.controller;

import cn.tpson.demo.common.dto.Result;
import cn.tpson.demo.springbootdubbo.api.remoteservice.UserRemoteService;
import cn.tpson.demo.springbootdubbo.common.dto.UserDTO;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zhangka in 2018/10/23
 */
@RestController
public class UserController {

    @Reference
    private UserRemoteService userRemoteService;

    @RequestMapping("/hello")
    public Result<UserDTO> sayHello(@RequestParam String name) {
        return userRemoteService.findByUsername(name);
    }

}

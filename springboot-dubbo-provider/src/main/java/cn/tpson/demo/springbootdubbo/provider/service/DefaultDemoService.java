package cn.tpson.demo.springbootdubbo.provider.service;


import cn.tpson.demo.springbootdubbo.api.service.DemoService;
import cn.tpson.demo.springbootdubbo.provider.mapper.UserMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Zhangka in 2018/10/23
 */
@Service
@Transactional(readOnly = true)
public class DefaultDemoService implements DemoService {
    @Autowired
    private UserMapper userRepository;

    public String sayHello(String name) {
        return JSON.toJSONString(userRepository.findAll());
    }
}

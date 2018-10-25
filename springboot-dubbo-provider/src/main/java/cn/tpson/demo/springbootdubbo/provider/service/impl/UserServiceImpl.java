package cn.tpson.demo.springbootdubbo.provider.service.impl;

import cn.tpson.demo.common.util.BeanCovertUtils;
import cn.tpson.demo.springbootdubbo.common.dto.UserDTO;
import cn.tpson.demo.springbootdubbo.common.query.UserQUERY;
import cn.tpson.demo.springbootdubbo.provider.domain.UserDO;
import cn.tpson.demo.springbootdubbo.provider.mapper.BaseMapper;
import cn.tpson.demo.springbootdubbo.provider.mapper.UserMapper;
import cn.tpson.demo.springbootdubbo.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Zhangka in 2018/10/24
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserQUERY, UserDO> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    protected BaseMapper<UserDO, UserQUERY> mapper() {
        return userMapper;
    }

    @Override
    public UserDTO findByUsername(String username) {
        return BeanCovertUtils.beanCovert(UserDTO.class, userMapper.findByUsername(username));
    }
}

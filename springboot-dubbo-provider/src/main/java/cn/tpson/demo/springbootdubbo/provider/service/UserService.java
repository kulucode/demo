package cn.tpson.demo.springbootdubbo.provider.service;

import cn.tpson.demo.springbootdubbo.common.dto.UserDTO;
import cn.tpson.demo.springbootdubbo.common.query.UserQUERY;

/**
 * Created by Zhangka in 2018/10/24
 */
public interface UserService extends BaseService<UserDTO, UserQUERY> {
    UserDTO findByUsername(String username);
}

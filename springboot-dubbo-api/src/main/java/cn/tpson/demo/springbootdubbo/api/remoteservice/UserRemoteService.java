package cn.tpson.demo.springbootdubbo.api.remoteservice;

import cn.tpson.demo.common.dto.Result;
import cn.tpson.demo.springbootdubbo.common.dto.UserDTO;
import cn.tpson.demo.springbootdubbo.common.query.UserQUERY;

/**
 * Created by Zhangka in 2018/10/23
 */
public interface UserRemoteService extends BaseRemoteService<UserDTO, UserQUERY> {
    Result<UserDTO> findByUsername(String username);
}

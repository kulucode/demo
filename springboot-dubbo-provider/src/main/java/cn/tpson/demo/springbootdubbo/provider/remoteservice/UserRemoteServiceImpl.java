package cn.tpson.demo.springbootdubbo.provider.remoteservice;

import cn.tpson.demo.common.dto.Result;
import cn.tpson.demo.springbootdubbo.api.remoteservice.UserRemoteService;
import cn.tpson.demo.springbootdubbo.common.dto.UserDTO;
import cn.tpson.demo.springbootdubbo.common.query.UserQUERY;
import cn.tpson.demo.springbootdubbo.provider.service.BaseService;
import cn.tpson.demo.springbootdubbo.provider.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Zhangka in 2018/10/24
 */
@Service
public class UserRemoteServiceImpl extends BaseRemoteServiceimpl<UserDTO, UserQUERY> implements UserRemoteService {
    @Autowired
    private UserService userService;

    @Override
    public Result<UserDTO> findByUsername(String username) {
        try {
            UserDTO userDTO = userService.findByUsername(username);
            return Result.successResult(userDTO);
        } catch (Exception e) {
            logger.error("findByUsername", e);
            return Result.failResult(ERROR_MSG_SELECT_ERROR);
        }
    }



    @Override
    protected BaseService<UserDTO, UserQUERY> baseService() {
        return userService;
    }
}

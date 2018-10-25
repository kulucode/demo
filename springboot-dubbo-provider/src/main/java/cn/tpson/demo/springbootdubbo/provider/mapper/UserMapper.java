package cn.tpson.demo.springbootdubbo.provider.mapper;

import cn.tpson.demo.springbootdubbo.common.query.UserQUERY;
import cn.tpson.demo.springbootdubbo.provider.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Zhangka in 2018/10/23
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO, UserQUERY> {
    UserDO findByUsername(String username);
}

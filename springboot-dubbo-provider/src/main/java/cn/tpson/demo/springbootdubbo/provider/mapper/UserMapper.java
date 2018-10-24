package cn.tpson.demo.springbootdubbo.provider.mapper;

import cn.tpson.demo.springbootdubbo.provider.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Zhangka in 2018/10/23
 */
@Mapper
public interface UserMapper {
    @Select("SELECT id, is_deleted AS deleted, gmt_create, gmt_modified, version, username, password FROM t_user")
    List<UserDO> findAll();

    List<UserDO> findByUsername(String username);
}

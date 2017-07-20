package com.gaige.pms.dao;

import com.gaige.pms.dao.provider.UserDynamicProvider;
import com.gaige.pms.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static com.gaige.pms.common.PmsConstants.USERTABLE;

@Repository
public interface UserDao {

    //根据用户名密码查询用户
    @Select("select * from "+USERTABLE+" where loginname=#{loginname} and password=#{password}")
    User selectByLoginNameAndPassword(@Param("loginname")String loginName, @Param("password")String password);

    //根据ID查询用户
    @Select("select * from "+USERTABLE+"where id=#{id}")
    User selectById(@Param("id")Integer id);

    //根据ID删除用户
    @Delete("delete * from"+USERTABLE+"where id=#{id}")
    void deleteById(@Param("id")Integer id);

    //动态更新用户
    @SelectProvider(type=UserDynamicProvider.class,method = "selectWithParam")
    void update(User user);

    //用户总数
    @SelectProvider(type = UserDynamicProvider.class,method = "count")
    Integer count(Map<String,Object>params);

    //动态更改用户信息
    @SelectProvider(type = UserDynamicProvider.class,method = "save")
    void save(User user);
}

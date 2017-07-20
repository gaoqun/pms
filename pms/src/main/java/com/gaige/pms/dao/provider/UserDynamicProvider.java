package com.gaige.pms.dao.provider;

import com.gaige.pms.domain.User;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

import static com.gaige.pms.common.PmsConstants.USERTABLE;

/**
 * 动态提供sql
 */
public class UserDynamicProvider {
    //分页动态查询
    public String selectWithParam(Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(USERTABLE);
                if (params.get("user") != null) {
                    User user = (User) params.get("user");
                    if (user.getUsername() != null && !"".equals(user.getUsername())) {
                        WHERE("username like concat('%',#{username},'%')");
                    }
                    if (user.getStatus() != null && !"".equals(user.getStatus())) {
                        WHERE("status like concat('%'),#{status},'%'");
                    }
                }
            }
        }.toString();
        if (params.get("pageModel") != null) {
            sql += "limit #{pageModel.firstLimitParam},#{pageModel.pageSize}";
        }
        return sql;
    }

    //动态查询总数量
    public String count(Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("count(*)");
                FROM(USERTABLE);
                if (params.get("user") != null) {
                    User user = (User) params.get("user");
                    if (user.getUsername() != null && !"".equals(user.getUsername())) {
                        WHERE("username LIKE CONCAT ('%',#{username},'%')");
                    }
                    if (user.getStatus() != null && !"".equals(user.getStatus())) {
                        WHERE("status like concat('%'),#{status},'%'");
                    }
                }
            }
        }.toString();
        return sql;
    }

    //动态插入
    public String save(User user) {
        return new SQL() {
            {
                INSERT_INTO(USERTABLE);
                if (user.getUsername() != null && !"".equals(user.getUsername())) {
                    VALUES("username", "#{username}");
                }
                if (user.getStatus() != null && !"".equals(user.getStatus())) {
                    VALUES("status", "#{status}");
                }
                if (user.getLoginname() != null && !"".equals(user.getLoginname())) {
                    VALUES("loginname", "#{loginname}");
                }
                if (user.getPassword() != null && !"".equals(user.getPassword())) {
                    VALUES("password", "#{password}");
                }
            }
        }.toString();
    }

    //动态更新
    public String updateUser(User user) {
        return new SQL() {
            {
                UPDATE(USERTABLE);
                if (user.getUsername() != null) {
                    SET("username=#{username}");
                }
                if (user.getLoginname() != null) {
                    SET("loginname=#{loginname}");
                }
                if (user.getPassword() != null) {
                    SET("password=#{password}");
                }
                if (user.getStatus() != null) {
                    SET("status=#{status}");
                }
                if (user.getCreateDate() != null) {
                    SET("createDate=#{createDate}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }

}

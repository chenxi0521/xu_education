package com.youxue.dao.impl;

import com.youxue.dao.UserDao;
import com.youxue.entity.User;
import com.youxue.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author chenxi
 * @date 2021/9/6 16:26
 * @description
 */
public class UserDaoImpl implements UserDao {

    private QueryRunner qr = JdbcUtil.getQueryRunner();

    @Override
    public User queryUser(String username,String password) {
        User res = null;
        String sql = "select * from user where username=? and password=?";

        try {
            res = qr.query(sql, new BeanHandler<>(User.class), username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return res;
    }

    @Override
    public User getUserById(long id) {
        User res = null;
        String sql = "select * from user where uid=?";

        try {
            res = qr.query(sql, new BeanHandler<>(User.class), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public User getuserByPhone(String phone) {

        User res = null;
        String sql = "select * from user where phone=?";

        try {
            res = qr.query(sql, new BeanHandler<>(User.class), phone);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public User getUserByUsername(String username) {
        User res = null;
        String sql = "select * from user where username=?";

        try {
            res = qr.query(sql, new BeanHandler<>(User.class), username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public User queryUserByPhone(String phone, String password) {
        User res = null;
        String sql = "select * from user where phone=? and password=?";

        try {
            res = qr.query(sql, new BeanHandler<>(User.class), phone,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public List<User> getAllUser() {
        List<User> list = null;
        String sql = "select * from user";

        try {
            list = qr.query(sql,new BeanListHandler<>(User.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public int editUser(User user) {
        int res = 0;
        String sql = "update user set name=?,phone=?,age=?,sex=?,username=?,password=?,status=?,createtime=?,role=?,picture=? where uid=?";

        try {
            res = qr.update(sql,user.getUsername(),user.getPhone(),user.getSex(),user.getSex(),user.getUsername(),user.getPassword(),user.getStatus(),user.getCreatetime(),user.getRole(),user.getPicture(),user.getUid());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int getUsersTotalCount() {
        int res = 0;
        String sql = "select count(*) from user";

        try {
            res =(int)(long)qr.query(sql,new ScalarHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  res;
    }

    @Override
    public List<User> getUsersByPage(int index, int rows) {
        List<User> list = null;
        String sql = "select * from user limit ?,?";

        try {
            list = qr.query(sql,new BeanListHandler<>(User.class),index,rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public int addUser(User user) {
        int res = 0;
        String sql = "insert into user set name=?,phone=?,age=?,sex=?,username=?,password=?,status=?,createtime=?,role=?,picture=?";
        try {
            res = qr.update(sql,user.getName(),user.getPhone(),user.getAge(),user.getSex(),user.getUsername(),user.getPassword(),user.getStatus(),user.getCreatetime(),user.getRole(),user.getPicture());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    @Override
    public int getUsersTotalCountBySearch(String search) {
        int res = 0;
        String sql = "select count(*) from user where username like '%"+search+"%'";

        try {
            res =(int)(long)qr.query(sql,new ScalarHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  res;
    }

    @Override
    public List<User> getUsersBySearch(int index, int rows, String search) {
        List<User> list = null;
        String sql = "select * from user where username like '%"+search+"%' limit ?,?";

        try {
            list = qr.query(sql,new BeanListHandler<>(User.class),index,rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public int delAll(String uids) {
        int res = 0;
        String sql = "delete from user where uid in("+uids+")";

        try {
            res = qr.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  res;
    }


}

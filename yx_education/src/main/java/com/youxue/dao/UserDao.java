package com.youxue.dao;

import com.youxue.entity.User;

import java.util.List;

/**
 * @author chenxi
 * @date 2021/9/6 16:26
 * @description
 */
public interface UserDao {
    public User queryUser(String username,String password);

    public List<User> getAllUser();

    public int editUser(User user);

    public int getUsersTotalCount();

    public List<User> getUsersByPage(int index,int rows);

    public int addUser(User user);

    int getUsersTotalCountBySearch(String search);

    List<User> getUsersBySearch(int index, int rows, String search);

    int delAll(String uids);

    User getUserById(long id);

    User getuserByPhone(String phone);

    User getUserByUsername(String username);

    User queryUserByPhone(String phone, String password);
}

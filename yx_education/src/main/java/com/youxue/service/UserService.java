package com.youxue.service;

import com.youxue.entity.User;

import javax.servlet.http.HttpSession;

/**
 * @author chenxi
 * @date 2021/9/6 16:30
 * @description
 */
public interface UserService {

    public String loginVerification(String username, String password, String code, HttpSession session);

    public String getAllUser();

    public String editUser(User user);

    public int getUsersTotalCount();

    public String getUsersByPage(int currentPage,int rows,int totalRows );

    public String AddUser(User user);

    public int getUsersTotalCountBySearch(String search);

    public String getUsersBySearch(int currentPage, int rows, int totalRows, String search);

    String delAll(String uids);

    String getuserByPhone(String phone);

    String getUserByUsername(String username);

    String loginByPhone(String phone, String password);

}

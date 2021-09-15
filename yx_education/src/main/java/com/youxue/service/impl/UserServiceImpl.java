package com.youxue.service.impl;

import com.youxue.dao.UserDao;
import com.youxue.dao.impl.UserDaoImpl;
import com.youxue.entity.User;
import com.youxue.service.UserService;
import com.youxue.util.JsonUtil;
import com.youxue.util.PageUtil;
import com.youxue.util.ResultUtil;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author chenxi
 * @date 2021/9/6 16:31
 * @description
 */
public class UserServiceImpl implements UserService {

    UserDao ud = new UserDaoImpl();

    @Override
    public String loginVerification(String username, String password, String code, HttpSession session) {
        ResultUtil ru = null;
        String verCode = (String)session.getAttribute("verCode");
        System.out.println("code:"+code +"/tvercode"+verCode);
        if (code.equalsIgnoreCase(verCode)){
            User user = ud.queryUser(username, password);
            if (user != null){
                if (user.getStatus() == 1){
                    if(user.getRole() == 1){
                        //登录成功
                        session.setAttribute("user",user);
                        ru = new ResultUtil(1,"登录成功",null);
                    }else {
                        //不是管理员
                        ru = new ResultUtil(2,"不是管理员账号,请联系工作人员",null);
                    }
                }else {
                    //账号禁用
                    ru = new ResultUtil(3,"账号已禁用,请联系工作人员",null);
                }
            }else {
                //账号密码错误
                ru = new ResultUtil(4,"账号密码输入有误,请重新登录",null);
            }
        }else {
            //验证码有误
            ru = new ResultUtil(5,"验证码输入有误,请重新输入",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String getAllUser() {
        List<User> allUser = ud.getAllUser();
        return JsonUtil.toJson(allUser);
    }

    @Override
    public String editUser(User user) {
        ResultUtil ru = null;
        int res = ud.editUser(user);
        if (res == 1){
            ru = new ResultUtil(1,"修改成功",null);
        }else {
            ru = new ResultUtil(0,"数据有误,修改失败",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public int getUsersTotalCount() {
        return ud.getUsersTotalCount();
    }

    @Override
    public String getUsersByPage(int currentPage,int rows,int totalRows) {
        PageUtil<User> pageUtil = new PageUtil(currentPage,rows,totalRows);
        List<User> usersByPage = ud.getUsersByPage(pageUtil.getIndex(), pageUtil.getRows());
        pageUtil.setList(usersByPage);
        return JsonUtil.toJson(pageUtil);
    }

    @Override
    public String AddUser(User user) {
        ResultUtil ru = null;
        int res = ud.addUser(user);
        if (res == 1){
            ru = new ResultUtil(1,"添加成功",null);
        }else {
            ru = new ResultUtil(0,"数据有误,添加失败",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public int getUsersTotalCountBySearch(String search) {
        return ud.getUsersTotalCountBySearch(search);
    }

    @Override
    public String getUsersBySearch(int currentPage, int rows, int totalRows, String search) {
        PageUtil<User> pageUtil = new PageUtil(currentPage,rows,totalRows);
        List<User> usersBySearch = ud.getUsersBySearch(pageUtil.getIndex(), pageUtil.getRows(),search);
        pageUtil.setList(usersBySearch);
        return JsonUtil.toJson(pageUtil);
    }

    @Override
    public String delAll(String uids) {
        ResultUtil ru = null;
        int res = ud.delAll(uids);
        if (res != 0){
            ru = new ResultUtil(1,"删除成功",null);
        }else {
            ru = new ResultUtil(0,"删除失败",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String getuserByPhone(String phone) {
        ResultUtil ru = null;
        User res = ud.getuserByPhone(phone);
        if (res != null){
            ru = new ResultUtil(1,"手机号已注册",res);
        }else {
            ru = new ResultUtil(0,"手机号未注册",null);
        }
        return JsonUtil.toJson(ru);

    }

    @Override
    public String getUserByUsername(String username) {
        ResultUtil ru = null;
        User res = ud.getUserByUsername(username);
        if (res != null){
            ru = new ResultUtil(1,"账号已占用",res);
        }else {
            ru = new ResultUtil(0,"账号可使用",null);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String loginByPhone(String phone, String password) {
        ResultUtil ru = null;
        User user = ud.queryUserByPhone(phone, password);
        if (user != null){
            if (user.getStatus() == 1){
                ru = new ResultUtil(1,"登陆成功",user);
            }else {
                ru = new ResultUtil(2,"账号已禁用,请联系工作人员",null);
            }
        }else {
            ru = new ResultUtil(0,"账号密码错误",null);
        }
        return  JsonUtil.toJson(ru);
    }



}

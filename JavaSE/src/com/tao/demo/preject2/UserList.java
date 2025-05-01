package com.tao.demo.preject2;

import com.tao.demo.util.Tools;

import java.util.Random;

/**
 * @author LTMAX
 * @version 1.0
 * @description: 用户列表
 * @date 2024/1/2 22:31
 */
public class UserList {
    /**
     *用户列表
     */
    private User[] userList;
    private Integer userCount;

    public Integer getUserCount() {
        return userCount;
    }


    /**
     *初始化用户列表
     */
    public UserList(){
        //初始化用户
        initUserList();
    }

    private void initUserList() {
        Random random = new Random();
        //初始容量为20
        userList = new User[20];
        //初始化5个用户
        for (int i = 0; i < 5; i++) {
            userList[i] = new User(i, Tools.generateRandomName(),Tools.generateRandomGender(),random.nextInt(121));
        }
        userCount = 5;
    }

    /**
     * 查询用户
     */
    public User[] getUserList() {
        return userList;
    }

    /**
     *新增用户
     */
    public void addUser(User user){
        //扩容
        if(userCount == userList.length){
            User[] newUserList = new User[userList.length + 10];
            System.arraycopy(userList,0,newUserList,0,userList.length);
            userList = newUserList;
        }

        //新增用户
        user.setId(userCount);
        userList[userCount] = user;
        userCount++;
    }

    /**
     *删除用户
     * @param id
     */
    public void deleteUser(Integer id){
        //删除用户
        if (userList[id] != null) {
            userList[id] = null;
        }else {
            System.out.println("用户不存在");
        }
    }



    /**
     *修改用户
     */
    public void updateUser(User user){
        userList[user.getId()].setName(user.getName());
        userList[user.getId()].setSex(user.getSex());
        userList[user.getId()].setAge(user.getAge());
    }

    /**
     * 用户是否存在
     */
    public boolean isExist(Integer id){
        return userList[id] != null;
    }
}

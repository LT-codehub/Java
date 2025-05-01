package com.tao.demo.preject2;

import java.util.Scanner;

/**
 * @author LTMAX
 * @version 1.0
 * @description: 用户视图
 * @date 2024/1/2 22:59
 */
public class UserView {

    private static UserList userList;

    /**
     *控制台系统界面
     */
    public static void main(String[] args) {
        userList = new UserList();
        boolean state = true;
        Scanner scanner = new Scanner(System.in);
        while (state){
            // 1. 显示系统界面
            view();
            // 2. 获取用户输入
            int input = scanner.nextInt();
            // 3. 根据用户输入做相应的处理
            switch (input){
                case 1:
                    // 查看用户列表
                    viewUserList();
                    break;
                case 2:
                    // 新增用户
                    addUser(scanner);
                    break;
                case 3:
                    // 删除用户
                    deleteUser(scanner);
                    break;
                case 4:
                    // 修改用户
                    updateUser(scanner);
                    break;
                case 5:
                    // 退出系统
                    System.out.println("确定退出系统？Y/N");
                    if ("Y".equalsIgnoreCase(scanner.nextLine())){
                        state = false;
                    }
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }

    }

    private static void updateUser(Scanner scanner) {
        System.out.println("==========修改用户==========");
        System.out.println("请输入要修改的用户名的编号");
        Integer id = scanner.nextInt();
        if (!userList.isExist(id)) {
            System.out.println("用户不存在");
        }else {
            System.out.println("请输入要修改的用户名");
            String name = scanner.next();
            System.out.println("请输入要修改的年龄");
            Integer age = scanner.nextInt();
            System.out.println("请输入要修改的性别");
            String gender = scanner.next();
            User user = new User(id, name,gender, age);
            userList.updateUser(user);
        }


    }


    private static void deleteUser(Scanner scanner) {
        System.out.println("==========删除用户==========");
        System.out.println("请输入要删除的用户名的编号");
        Integer id = scanner.nextInt();
        userList.deleteUser(id);
    }


    private static void addUser(Scanner scanner) {
        System.out.println("==========新增用户==========");
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入性别");
        String gender = scanner.nextLine();
        System.out.println("请输入年龄");
        int age = scanner.nextInt();
        // 创建用户对象
        User user = new User(null,username,gender,age);
        userList.addUser(user);
    }


    private static void viewUserList() {
        System.out.println("==========用户列表==========");
        System.out.println("---------------------------");
        // 1. 遍历集合
        System.out.println("编号\t\t用户名\t\t性别\t\t年龄");
        for (int i = 0; i <userList.getUserCount(); i++) {
            User user = userList.getUserList()[i];
            System.out.println(user.getId()+"\t\t"+user.getName()+"\t\t"+user.getSex()+"\t\t"+user.getAge());
        }

    }


    // 3. 根据用户输入做相应的处理 while ()


    private static void view(){
        System.out.println("==========欢迎使用用户管理系统系统==========");
        System.out.println("             1. 查看用户列表");
        System.out.println("             2. 新增用户");
        System.out.println("             3. 删除用户");
        System.out.println("             4. 修改用户");
        System.out.println("             5. 退出");
        System.out.println("========================================");
    }

}

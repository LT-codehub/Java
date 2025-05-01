package com.se.unit9.exer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author LTMAX
 * @version 1.0
 * @className: KTVByArrayList
 * @package: com.se.unit9.exer
 * @description: TODO
 * @date 2024/1/20 0:31
 */
public class KTVByArrayList {
    private static ArrayList<String> songs;

    public static void main(String[] args) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag){
            //主界面
            view();
            int code = scanner.nextInt();
            switch (code){
                case 1:
                    System.out.println("请输入歌曲名：");
                    String song = scanner.next();
                    add(song);
                    list();
                    break;
                case 2:
                    System.out.println("请输入歌曲名：");
                    String song2 = scanner.next();
                    setTop(song2);
                    list();
                    break;
                case 3:
                    list();
                    System.out.println("请输入歌曲名：");
                    String song3 = scanner.next();
                    move(song3);
                    break;
                case 4:
                    System.out.println("退出系统Y/N");
                    String exit = scanner.next();
                    if (exit.equalsIgnoreCase("Y")){
                        flag = false;
                    }
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }
    }

    private static void move(String song3) {
        int i = songs.indexOf(song3);
        if (i > 0) {
            System.out.println("歌曲不存在");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择上移或者下移：");
        System.out.println("1.上移：");
        System.out.println("2.下移：");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                String s = songs.get(i - 1);
                songs.add(i - 1, song3);
                songs.remove(i + 1);
                System.out.println("上移成功");
                break;
            case 2:
                songs.add(i + 2, song3);
                songs.remove(i);
                System.out.println("下移成功");
                break;
            default:
                System.out.println("输入有误，请重新输入");
                break;
        }

    }

    private static void add(String song) {
        if (songs == null) {
            songs = new ArrayList<>();
        }
        songs.add(song);
        System.out.println("添加成功");
    }

    private static void setTop(String song2) {
        ArrayList<String> list = new ArrayList<>();
        list.add(song2);
        list.addAll(songs);
        songs = list;
        System.out.println("置顶成功");
    }

    private static void view() {
        System.out.println("欢迎来到KTV点歌系统");
        System.out.println("1.点歌");
        System.out.println("2.歌曲置顶");
        System.out.println("3.歌曲前移&后移");
        System.out.println("4.歌曲列表");
        System.out.println("5.退出");
        System.out.println("请输入功能编号：");
    }

    private  static void list() {
        if (songs == null) {
            System.out.println("当前没有歌曲，请先点歌");
            return;
        }

        System.out.println("当前歌曲列表如下：");
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }
    }


}

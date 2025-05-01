package com.se.temp;

/**
 * @author LTMAX
 * @date 2023/9/22 15:00
 * @description: TODO
 */
public enum Color {
    /**
     *颜色
     */
    RED("红色"),BLUE("蓝色"),GREEN("绿色"),YELLOW("黄色"),PURPLE("紫色"),BLACK("黑色"),WHITE("白色"),ORANGE("橙色");

    /**
     *颜色
     */
    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

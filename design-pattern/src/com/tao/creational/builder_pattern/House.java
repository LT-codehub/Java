package com.tao.creational.builder_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: House
 * @package: com.tao.creational.builder_pattern
 * @description: TODO
 * @date 2024/2/18 19:35
 */
public class House {
    private String baise;
    private String wall;
    private String roofed;

    public House(String baise, String wall, String roofed) {
        this.baise = baise;
        this.wall = wall;
        this.roofed = roofed;
    }

    public House() {
    }

    public String getBaise() {
        return baise;
    }

    public void setBaise(String baise) {
        this.baise = baise;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
}

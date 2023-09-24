package com.se.unit12;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/16 22:51
 */
public class EntryTest {
    private Integer id;
    private String name;

    public EntryTest() {
    }

    public EntryTest(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

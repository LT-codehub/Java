package com.se.unit13;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/17 12:40
 */
public class Generic<E> {

    private E e;

    Object get(){
        return new Object();
    }

    Boolean set(E e){
        return true;
    }

    public static void main(String[] args) {
        Generic<Object> objectGeneric = new Generic<>();
    }
}

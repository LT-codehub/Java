package com.se.unit10;

/**
 * @author LTMAX
 * @version 1.0
 * @className: GenericClass
 * @package: com.se.unit10
 * @description: 泛型类
 * @date 2024/1/21 21:37
 */
public class GenericClass<T> {
    private  T value;
    public static void main(String[] args) {
        //
        GenericClass<String> genericClass = new GenericClass<>();
        genericClass.setValue("Hello");
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

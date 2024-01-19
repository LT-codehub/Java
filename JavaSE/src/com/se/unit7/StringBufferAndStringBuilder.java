package com.se.unit7;

/**
 * @author LTMAX
 * @version 1.0
 * @className: StringBufferAndStringBuilder
 * @package: com.se.unit7
 * @description: TODO
 * @date 2024/1/18 20:41
 */
public class StringBufferAndStringBuilder {
    public static void main(String[] args) {
        String str = new String();
        StringBuffer buffer = new StringBuffer();
        StringBuilder builder = new StringBuilder();
        System.out.println(str.length());
        System.out.println(buffer.length());
        System.out.println(builder.length());

        str = null;
        Object obj = null;
        for (int i = 0; i < 10; i++) {
            buffer.append(obj);
        }
        System.out.println(buffer.toString());

    }
}

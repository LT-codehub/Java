package com.se.unit7;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/16 19:25
 */
public class ComparableTest implements Comparable{

    private Integer id;
    private String name;

    @Override
    public int compareTo(Object o) {
        if(o instanceof ComparableTest) {
            ComparableTest that = (ComparableTest) o;
            if (this == that){
                return 0;
            }
            return this.id.compareTo(that.id);
        }else {
            throw new RuntimeException("传入类异常");
        }
    }
}

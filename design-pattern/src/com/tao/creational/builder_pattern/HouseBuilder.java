package com.tao.creational.builder_pattern;

/**
 * @author LTMAX
 * @date 2024/2/18 19:34
 * @description: TODO
 */
public abstract class HouseBuilder {
    protected House house = new House();
    //将建造的流程写好，抽象的方法
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();
    //建造房子好，将产品（房子）返回

    public House buildHouse(){
        return house; }
}

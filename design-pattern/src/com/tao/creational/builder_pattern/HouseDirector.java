package com.tao.creational.builder_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: HouseDirector
 * @package: com.tao.creational.builder_pattern
 * @description: TODO
 * @date 2024/2/18 19:40
 */
public class HouseDirector {

    HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //建造者模式更关注建造的过程，过程是固定的，所以将建造的过程写死在Director中
    public House constructHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}

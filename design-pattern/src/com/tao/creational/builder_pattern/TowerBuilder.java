package com.tao.creational.builder_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: TowerBuilder
 * @package: com.tao.creational.builder_pattern
 * @description: TODO
 * @date 2024/2/18 19:41
 */
public class TowerBuilder extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("打地基5米");
    }

    @Override
    public void buildWalls() {
        System.out.println("砌墙10cm");
    }

    @Override
    public void roofed() {
        System.out.println("建屋顶");
    }
}

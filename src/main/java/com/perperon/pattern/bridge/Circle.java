package com.perperon.pattern.bridge;

/**
 * @author dupengcheng
 * @date 2024-03-18
 * @apiNote
 */
public class Circle extends Shape{
    public Circle(DrawAPI drawApi) {
        super(drawApi);
    }
    @Override
    public void draw() {
        drawAPI.drawCircle(0,0,10);
    }
}

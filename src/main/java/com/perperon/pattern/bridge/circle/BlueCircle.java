package com.perperon.pattern.bridge.circle;

import com.perperon.pattern.bridge.DrawAPI;

/**
 * @author dupengcheng
 * @date 2024-03-18
 * @apiNote
 */
public class BlueCircle implements DrawAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("Drawing Circle [ Color: Blue, x: " + x + ", y: " + y + ", radius: " + radius + " ]");
    }
}

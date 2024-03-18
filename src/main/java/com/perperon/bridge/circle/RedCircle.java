package com.perperon.bridge.circle;

import com.perperon.bridge.DrawAPI;

/**
 * @author dupengcheng
 * @date 2024-03-18
 * @apiNote
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("Drawing Circle [ Color: Red, x: " + x + ", y: " + y + ", radius: " + radius + " ]");
    }
}

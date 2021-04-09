package com.lab6.optional;

import java.awt.*;

public class Rectangle extends Polygon {
    public Rectangle(int x0 , int y0 , int width, int height){
        this.addPoint(x0 - width / 2 , y0 + height / 2);
        this.addPoint(x0 - width / 2 , y0 - height / 2);
        this.addPoint(x0 + width / 2 , y0 - height / 2);
        this.addPoint(x0 + width / 2 , y0 + height / 2);
    }
}

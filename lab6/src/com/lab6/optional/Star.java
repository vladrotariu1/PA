package com.lab6.optional;

import java.awt.*;

public class Star extends Polygon {
    public Star(int x0, int y0, int radius, int sides) {
        double alpha = Math.PI / sides;
        for (int i = 0; i < sides * 2; i++) {
            double x, y;
            if (i % 2 == 0) {
                x = x0 + (double) radius / 3 * Math.cos(alpha * i);
                y = y0 + (double) radius / 3 * Math.sin(alpha * i);
            } else {
                x = x0 + (double) radius * Math.cos(alpha * i);
                y = y0 + (double) radius * Math.sin(alpha * i);
            }
            this.addPoint((int) x, (int) y);
        }
    }
}

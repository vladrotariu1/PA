package com.lab6.optional;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import javax.swing.*;

public class ShapePanel extends JPanel{

    final MainFrame frame;
    JLabel label;
    JComboBox comboBox;

    public ShapePanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    private void init() {
        label = new JLabel("Choose figure");
        comboBox = new JComboBox(new String[]{"Star", "Rectangle", "Polygon"});

        add(label);
        add(comboBox);
    }
}

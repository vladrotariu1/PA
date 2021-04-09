package com.lab6.optional;

import javax.swing.*;

public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel sidesLabel;
    JSpinner sidesField;
    JComboBox colorCombo;
    JLabel sizeLabel;
    JSpinner sizeField;
    JLabel widthLabel;
    JSpinner widthField;
    JLabel heightLabel;
    JSpinner heightField;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    public JSpinner getSizeField() {
        return sizeField;
    }

    public JComboBox getColorCombo() {
        return colorCombo;
    }

    public JSpinner getWidthField() {
        return widthField;
    }

    public JSpinner getHeightField() {
        return heightField;
    }

    private void init() {
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 20, 1));
        sidesField.setValue(6);
        colorCombo = new JComboBox(new String[]{"Red", "Random"});

        add(sidesLabel);
        add(colorCombo);

        sizeLabel = new JLabel("Radius");
        sizeField = new JSpinner(new SpinnerNumberModel(20, 20, 800, 1));

        add(sizeLabel);
        add(sizeField);

        widthLabel = new JLabel("Width:");
        heightLabel = new JLabel("Height:");
        widthField = new JSpinner(new SpinnerNumberModel(30, 30, 800, 10));
        heightField = new JSpinner(new SpinnerNumberModel(30, 30, 800, 10));

        add(widthLabel);
        add(widthField);
        add(heightLabel);
        add(heightField);
    }

}

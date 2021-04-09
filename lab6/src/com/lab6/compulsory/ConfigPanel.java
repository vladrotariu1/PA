package com.lab6.compulsory;

import javax.swing.*;

public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel sidesLabel;
    JSpinner sidesField;
    JComboBox colorCombo;
    JLabel sizeLabel;
    JSpinner sizeField;

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

    private void init() {
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 20, 1));
        sidesField.setValue(6);
        colorCombo = new JComboBox(new String[]{"Red", "Random"});

        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);

        sizeLabel = new JLabel("Radius");
        sizeField = new JSpinner(new SpinnerNumberModel(20, 20, 800, 1));

        add(sizeLabel);
        add(sizeField);
    }

}
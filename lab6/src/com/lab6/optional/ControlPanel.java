package com.lab6.optional;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ControlPanel extends JPanel {

    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    List<Shape> shapesList;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        shapesList = new ArrayList<Shape>(10);
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void exit(ActionEvent actionEvent) {
        frame.dispose();
    }

    private void reset(ActionEvent actionEvent) {
        frame.getCanvas().resetBackground();
    }

    private void load(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileChooser.getSelectedFile().getAbsolutePath()));
                shapesList = (List<Shape>) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println(shapesList.size());
        for (Shape s : shapesList)
            frame.getCanvas().drawShape(s);
    }

    private void save(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showSaveDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            try (ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(fileChooser.getSelectedFile().getAbsolutePath()))) {
                System.out.print(fileChooser.getSelectedFile().getAbsolutePath());
                oos.writeObject(shapesList);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public void addShape(Shape s) {
        shapesList.add(s);
    }
}

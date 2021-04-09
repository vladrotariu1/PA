package com.lab6.compulsory;

import com.sun.prism.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class ControlPanel extends JPanel {

    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
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
                BufferedImage img = ImageIO.read(new File(fileChooser.getSelectedFile().getAbsolutePath()));
                frame.getCanvas().setBackgroundImage(img);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void save(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showSaveDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(frame.getCanvas().getBackgroundImage(), "PNG", new File(Paths.get("photos/").toAbsolutePath().normalize().toString() + "/test.png"));
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
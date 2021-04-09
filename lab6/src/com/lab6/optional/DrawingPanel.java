package com.lab6.optional;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {

    final MainFrame frame;
    final static int W = 800, H = 600;

    BufferedImage backgroundImage;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(BufferedImage backgroundImage) {
        Graphics2D g2d = this.backgroundImage.createGraphics();
        g2d.drawImage(backgroundImage.getScaledInstance(W, H,Image.SCALE_DEFAULT), 0, 0, null);
        g2d.dispose();
    }

    private void createOffscreenImage() {
        backgroundImage = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = backgroundImage.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        ConfigPanel configPanel = frame.getConfigPanel();

        int radius = (Integer)configPanel.getSizeField().getValue();
        int sides = (Integer)configPanel.getSidesField().getValue();

        Color color;
        String colorString = (String) configPanel.getColorCombo().getSelectedItem();
        if(colorString.equals("Red"))
            color = Color.RED;
        else
        {
            Random rand = new Random();
            int red = rand.nextInt(255);
            int green = rand.nextInt(255);
            int blue = rand.nextInt(255);

            color = new Color(red , green , blue);
        }

        Shape shape;

        switch(frame.getShapePanel().getComboBox().getSelectedIndex()) {
            case 0: {
                shape = new Star(x, y, radius, sides);
                break;
            }

            case 1:
                int width = (Integer)configPanel.getWidthField().getValue();
                int height = (Integer)configPanel.getHeightField().getValue();
                shape = new Rectangle(x, y, width, height);
                break;

            default:
                shape = new RegularPolygon(x, y, radius, sides);
                break;
        }
        graphics.setColor(color);
        graphics.fill(shape);
        frame.getControlPanel().addShape(shape);
    }

    public void drawShape(Shape shape) {
        ConfigPanel configPanel = frame.getConfigPanel();

        Color color;
        String colorString = (String) configPanel.getColorCombo().getSelectedItem();
        if(colorString.equals("Red"))
            color = Color.RED;
        else
        {
            Random rand = new Random();
            int red = rand.nextInt(255);
            int green = rand.nextInt(255);
            int blue = rand.nextInt(255);

            color = new Color(red , green , blue);
        }

        graphics.setColor(color);
        graphics.fill(shape);
    }

    public void resetBackground() {
        backgroundImage = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = backgroundImage.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
        repaint();
    }

    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, this);
    }


}

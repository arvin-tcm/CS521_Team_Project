/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs532_mvccharts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Arvin
 */
class BarChart extends JFrame implements ActionListener {

    private ChartModel model;
    private final Color[] colorList = {Color.pink, Color.red, Color.white, Color.green, Color.cyan};
    private JPanel panel;

    public BarChart(ChartModel model) {
        this.model = model;
        model.addActionListener(this);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < model.getGpa().length; i++) {
                    int ax = 10 + i * 70;
                    int ay = getHeight();
                    int endY = (int) model.getGpa()[i] * 15;
                    g.setColor(colorList[i % 5]);
                    g.fillRect(ax, ay - endY, 60, endY);
                    //g.fillRect(ax, ay, 60, 0 - (int) model.getGpa()[i] * 15);
                    g.setColor(Color.black);
                    g.drawString(model.getCourseName()[i], ax, ay - endY - 5);
                    g.drawRect(ax, ay - endY, 60, endY);
                }
            }
        };
        add(panel);
        setTitle("Bar Chart");
        //setLayout(null);
        setSize(300, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.repaint();
    }
}

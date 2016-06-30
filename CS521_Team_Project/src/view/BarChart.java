/* 
 * Student Info: Name=Tsai-Chang Mai, ID=10010
 * Subject: CS521_Team_Project_Summer_2016
 * Author: Arvin-tcm 
 * Filename: BarChart.java 
 * Date and Time: Jun 29, 2016 10:07:58 PM 
 * Project Name: CS521_Team_Project 
 */
package view;

import model.ChartModel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BarChart extends JFrame implements ActionListener {

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
                    g.setColor(Color.black);
                    g.drawString(model.getCourseName()[i], ax, ay - endY - 5);
                    g.drawRect(ax, ay - endY, 60, endY);
                }
            }
        };
        add(panel);
        setTitle("Bar Chart");
        setSize(80 * model.getGpa().length, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.repaint();
    }
}

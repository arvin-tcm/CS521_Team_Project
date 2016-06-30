/* 
 * Student Info: Name=Tsai-Chang Mai, ID=10010
 * Subject: CS521_Team_Project_Summer_2016
 * Author: Arvin-tcm 
 * Filename: PieChart.java 
 * Date and Time: Jun 29, 2016 10:09:00 PM 
 * Project Name: CS521_Team_Project 
 */
package view;

import model.ChartModel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PieChart extends JFrame implements ActionListener {

    class MyPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            double radians, creditTotal = model.CreditsSum();
            int startAngle = 0;
            int x, y, radius, xCenter, yCenter;
            xCenter = getWidth() / 2;
            yCenter = getHeight() / 2;
            radius = (int) (Math.min(getWidth(), getHeight()) * 0.4);
            x = xCenter - radius;
            y = yCenter - radius;
            updateList();
            for (int i = 0; i < model.getCredits().length; i++) {
                int endAngle = (int) (360 * model.getCredits()[i] / creditTotal);
                g.setColor(colorList[i % 5]);
                g.fillArc(x, y, 2 * radius, 2 * radius, startAngle, endAngle);
                radians = Math.toRadians(startAngle + endAngle / 2);
                int ax = (int) (xCenter + (radius * Math.cos(radians)));
                int ay = (int) (yCenter - (radius * Math.sin(radians)));
                labelList.get(i).setSize(labelList.get(i).getPreferredSize());
                labelList.get(i).setLocation(ax, ay);
                startAngle += endAngle;
            }
            g.fillArc(x, y, 2 * radius, 2 * radius, startAngle, 360 - startAngle);
        }
    }
    private ChartModel model;
    private final Color[] colorList = {Color.pink, Color.red, Color.white, Color.green, Color.cyan};
    private final ArrayList<JLabel> labelList = new ArrayList<>();
    private final MyPanel panel = new MyPanel();

    public PieChart(ChartModel model) {
        this.model = model;
        model.addActionListener(this);

        setTitle("Pie Chart");

        panel.setLayout(null);
        updateList();
        getContentPane().add(panel);
        setSize(300, 300);
        setVisible(true);
    }

    public void updateList() {
        panel.removeAll();
        labelList.clear();
        for (String s : model.getCourseName()) {
            JLabel jlb = new JLabel(s);
            labelList.add(jlb);
            panel.add(jlb);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        panel.repaint();
    }
}

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
            double radians, creditTotal = model.creditsSum();
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

                //adjust the coordinate
                int height = (int) labelList.get(i).getPreferredSize().getHeight();
                int width = (int) labelList.get(i).getPreferredSize().getWidth();
                int mode = 0;
                if (isInCircle(xCenter, yCenter, ax, ay + height, radius)) {
                    mode += 1;
                }
                if (isInCircle(xCenter, yCenter, ax + width, ay, radius)) {
                    mode += 2;
                }
                if (isInCircle(xCenter, yCenter, ax + width, ay + height, radius)) {
                    mode += 4;
                }
                switch (mode) {
                    case 0:
                        labelList.get(i).setLocation(ax, ay);
                        break;
                    case 1:
                        labelList.get(i).setLocation(ax, ay - height);
                        break;
                    case 2:
                        labelList.get(i).setLocation(ax - width, ay);
                        break;
                    case 4:
                        labelList.get(i).setLocation(ax - width, ay);
                        break;
                    case 5:
                        labelList.get(i).setLocation(ax, ay - height);
                        break;
                    case 6:
                        labelList.get(i).setLocation(ax - width, ay);
                        break;
                    case 7:
                        labelList.get(i).setLocation(ax - width, ay - height);
                        break;
                    default:
                        break;
                }
                startAngle += endAngle;
            }
            g.fillArc(x, y, 2 * radius, 2 * radius, startAngle, 360 - startAngle);
        }

        private boolean isInCircle(int xCenter, int yCenter, int x, int y, int radius) {
            if (radius < Math.sqrt(Math.pow(x - xCenter, 2) + Math.pow(y - yCenter, 2))) {
                return false;
            } else {
                return true;
            }
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
        setSize(500, 380);
        setVisible(true);
    }

    public void updateList() {
        panel.removeAll();
        labelList.clear();
        double sum = model.creditsSum();
        for (int i = 0; i < model.getCredits().length; i++) {
            String s = model.getCourseName()[i];
            s = s + "(" + String.format("%.2f", model.getCredits()[i] / sum * 100) + "%)";
            JLabel jlb = new JLabel(s);
            labelList.add(jlb);
            panel.add(jlb);
        }
        /*
        for (String s : model.getCourseName()) {
            s = s + "(" + + "%)";
            JLabel jlb = new JLabel(s);
            labelList.add(jlb);
            panel.add(jlb);
        }*/
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        panel.repaint();
    }
}

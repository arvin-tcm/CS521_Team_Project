/* 
 * Student Info: Name=Tsai-Chang Mai, ID=10010
 * Subject: CS521_Team_Project_Summer_2016
 * Author: Arvin-tcm 
 * Filename: ChartMain.java 
 * Date and Time: Jun 29, 2016 10:08:23 PM 
 * Project Name: CS521_Team_Project 
 */
package main;

import model.ChartModel;
import controller.ChartController;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.BarChart;
import view.PieChart;

public class ChartMain extends JFrame {

    private final JButton jbtController = new JButton("Controller");
    private final JButton jbtPieChartView = new JButton("Pei Chart");
    private final JButton jbtBarChartView = new JButton("Bar Chart");
    private final ChartModel model = new ChartModel();
    private ChartController controller = null;

    public ChartMain() {
        setLayout(new GridLayout(3, 1));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        getContentPane().add(panel1);
        getContentPane().add(panel2);
        getContentPane().add(panel3);
        panel1.add(jbtController);
        panel2.add(jbtPieChartView);
        panel3.add(jbtBarChartView);

        jbtController.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller = new ChartController(model);
            }
        });
        jbtPieChartView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller == null) {
                    JOptionPane.showMessageDialog(null,
                            "You must initialize the controller first to generate chart!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                PieChart chart = new PieChart(model);
            }
        });
        jbtBarChartView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller == null) {
                    JOptionPane.showMessageDialog(null,
                            "You must initialize the controller first to generate chart!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                BarChart chart = new BarChart(model);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ChartMain frame = new ChartMain();
    }

}

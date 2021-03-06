/* 
 * Student Info: Name=Tsai-Chang Mai, ID=10010
 * Subject: CS521_Team_Project_Summer_2016
 * Author: Arvin-tcm 
 * Filename: ChartController.java 
 * Date and Time: Jun 29, 2016 10:08:14 PM 
 * Project Name: CS521_Team_Project 
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import model.ChartModel;

public class ChartController extends JFrame {

    // list of all exist input components(GPA, course name, course credits)
    private final ArrayList<JComboBox> jcbGpaList = new ArrayList<>();
    private final ArrayList<JTextField> jtfCourseNameList = new ArrayList<>();
    private final ArrayList<JSpinner> jspCreditsList = new ArrayList<>();
    // label of each column(GPA, course name, course credits)
    private final JLabel jlbGPA = new JLabel("GPA");
    private final JLabel jlbCourseName = new JLabel("Course Name");
    private final JLabel jlbCredits = new JLabel("Credits");
    // button the save the record
    private final JButton jbtSave = new JButton("Save");
    // button to add new record
    private final JButton jbtAdd = new JButton("Add new data");
    // model for all the data
    private final ChartModel model;

    /**
     * user-defined constructor
     *
     * @param model
     */
    public ChartController(ChartModel model) {
        this.model = model;
        final GridLayout mainLayout = new GridLayout(0, 3);
        final JPanel dataPanel = new JPanel(mainLayout);
        final JPanel buttonPanel = new JPanel(new FlowLayout());
        final JPanel labelPanel = new JPanel(new GridLayout(1, 3));
        setTitle("Chart Controller");
        setLayout(new BorderLayout());
        add(dataPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(labelPanel, BorderLayout.NORTH);
        buttonPanel.add(jbtAdd);
        buttonPanel.add(jbtSave);

        jlbGPA.setHorizontalAlignment(JLabel.CENTER);
        jlbCourseName.setHorizontalAlignment(JLabel.CENTER);
        jlbCredits.setHorizontalAlignment(JLabel.CENTER);
        labelPanel.add(jlbCourseName);
        labelPanel.add(jlbGPA);
        labelPanel.add(jlbCredits);

        // initialize
        if (this.model.getGpa().length != 0) {
            for (int i = 0; i < this.model.getGpa().length; i++) {
                JTextField initJtfCourseName = new JTextField();
                JComboBox initJcbGpa = new JComboBox(model.getGpaKeyList());
                SpinnerNumberModel initNumModel = new SpinnerNumberModel(1, 0, 5, 1);
                JSpinner initJspCredits = new JSpinner(initNumModel);
                mainLayout.setRows(mainLayout.getRows() + 1);

                // setup components' size, and text alignment to center
                initJtfCourseName.setPreferredSize(new Dimension(140, 40));
                initJtfCourseName.setHorizontalAlignment(JTextField.CENTER);
                ((JLabel) initJcbGpa.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
                ((JSpinner.DefaultEditor) initJspCredits.getEditor()).getTextField().setHorizontalAlignment(JTextField.CENTER);

                //setup data
                initJtfCourseName.setText(model.getCourseName()[i]);
                initJcbGpa.setSelectedItem(model.getGpaKeyList()[i]);
                initJspCredits.setValue(model.getCredits()[i]);

                dataPanel.add(initJtfCourseName);
                dataPanel.add(initJcbGpa);
                dataPanel.add(initJspCredits);

                dataPanel.revalidate();
                dataPanel.repaint();

                // add all the components to the list as record
                jcbGpaList.add(initJcbGpa);
                jtfCourseNameList.add(initJtfCourseName);
                jspCreditsList.add(initJspCredits);

            }
        }
        pack();
        // add action listener to the button "Add"
        // add one addition row to the data panel
        jbtAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField jtfCourseName = new JTextField();
                JComboBox jcbGpa = new JComboBox(model.getGpaKeyList());
                SpinnerNumberModel numModel = new SpinnerNumberModel(1, 0, 5, 1);
                JSpinner jspCredits = new JSpinner(numModel);
                mainLayout.setRows(mainLayout.getRows() + 1);

                // setup components' size, and text alignment to center
                jtfCourseName.setPreferredSize(new Dimension(140, 40));
                jtfCourseName.setHorizontalAlignment(JTextField.CENTER);
                ((JLabel) jcbGpa.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
                ((JSpinner.DefaultEditor) jspCredits.getEditor()).getTextField().setHorizontalAlignment(JTextField.CENTER);

                dataPanel.add(jtfCourseName);
                dataPanel.add(jcbGpa);
                dataPanel.add(jspCredits);

                dataPanel.revalidate();
                dataPanel.repaint();

                // add all the components to the list as record
                jcbGpaList.add(jcbGpa);
                jtfCourseNameList.add(jtfCourseName);
                jspCreditsList.add(jspCredits);

                pack();
            }
        });

        // add action listener to the button "Save"
        // save the data to model and calculate the average GPA
        jbtSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count = jcbGpaList.size();
                double[] gpa = new double[count];
                ArrayList<String> courseName = new ArrayList<>();
                double result;
                int[] credits = new int[count];

                // generate the data set from all the input component as an array
                for (int i = 0; i < count; i++) {
                    String temp = jtfCourseNameList.get(i).getText();
                    gpa[i] = model.getGpaMap().get(jcbGpaList.get(i).getSelectedItem().toString());

                    // verify empty course name block
                    if (temp.isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Course name cannot have empty!",
                                "WARNING",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    } else if (courseName.contains(temp)) {
                        JOptionPane.showMessageDialog(null,
                                "Course name cannot have duplicate!",
                                "WARNING",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    } else {
                        courseName.add(temp);
                    }
                    credits[i] = (Integer) jspCreditsList.get(i).getValue();
                }

                // input data to the model
                model.setChartData((String[]) courseName.toArray(new String[0]), gpa, credits);

                // calculate the average GPA
                result = model.calculateAverageGpa();
                JOptionPane.showMessageDialog(null,
                        "Your average GPA is: " + new DecimalFormat("0.00").format(result),
                        "result",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
        setSize(500, 150);
        setVisible(true);
        //jbtAdd.doClick();
        //jbtSave.doClick();
    }
}

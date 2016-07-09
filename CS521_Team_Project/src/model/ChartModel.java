/* 
 * Student Info: Name=Tsai-Chang Mai, ID=10010
 * Subject: CS521_Team_Project_Summer_2016
 * Author: Arvin-tcm 
 * Filename: ChartModel.java 
 * Date and Time: Jun 29, 2016 10:08:31 PM 
 * Project Name: CS521_Team_Project 
 */
package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChartModel {

    // data set of all the gpa record
    private double[] gpa;
    // data set of all the course name record
    private String[] courseName;
    // data set of all the course credits record
    private int[] credits;
    // data set of the letter grades
    private final String[] gpaKeyList = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"};
    // data set of the grades value
    private final double[] gpaValueList = {4, 4, 3.7, 3.3, 3, 2.7, 2.3, 2, 1.7, 1.3, 1, 0.7, 0};
    // data mapping for letter grade and values
    private final Map<String, Double> gpaMap = new HashMap<>();
    // store all the action listener
    private final ArrayList<ActionListener> actionListenerList = new ArrayList<>();

    /**
     * Default constructor Initialize the map of letter grade and value
     */
    public ChartModel() {
        for (int i = 0; i < gpaKeyList.length; i++) {
            gpaMap.put(gpaKeyList[i], gpaValueList[i]);
        }
    }

    /**
     * add action listener
     *
     * @param l
     */
    public void addActionListener(ActionListener l) {
        actionListenerList.add(l);
    }

    /**
     * remove action listener
     *
     * @param l
     */
    public void removeActionListener(ActionListener l) {
        actionListenerList.remove(l);
    }

    /**
     * fire events
     *
     * @param e
     */
    private void processEvent(ActionEvent e) {
        for (ActionListener listener : actionListenerList) {
            listener.actionPerformed(e);
        }
    }

    @Override
    public String toString() {
        return "ChartModel{" + "data=" + gpa + ", dataName=" + courseName + '}';
    }

    /**
     * data input
     *
     * @param newDataName
     * @param newData
     * @param newCredit
     */
    public void setChartData(String[] newDataName, double[] newData, int[] newCredit) {
        courseName = newDataName;
        gpa = newData;
        credits = newCredit;
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "test"));
    }

    public void setGpa(double[] gpa) {
        this.gpa = gpa;
    }

    public void setCourseName(String[] courseName) {
        this.courseName = courseName;
    }

    public void setCredits(int[] credits) {
        this.credits = credits;
    }

    public String[] getGpaKeyList() {
        return gpaKeyList;
    }

    public double[] getGpaValueList() {
        return gpaValueList;
    }

    public Map<String, Double> getGpaMap() {
        return gpaMap;
    }

    public double[] getGpa() {
        return gpa;
    }

    public String[] getCourseName() {
        return courseName;
    }

    public int[] getCredits() {
        return credits;
    }

    /**
     * calculate the total sum of all the course credits
     *
     * @return sum
     */
    public double creditsSum() {
        double creditsSum = 0.0;
        for (double d : credits) {
            creditsSum += d;
        }
        return creditsSum;
    }

    /**
     * calculate the after all average GPA
     *
     * @return average GPA
     */
    public double calculateAverageGpa() {
        double totalGpa = 0, totalCredit = creditsSum();

        for (int i = 0; i < credits.length; i++) {
            totalGpa = totalGpa + (credits[i] * gpa[i]);
        }
        return totalGpa / totalCredit;
    }
}

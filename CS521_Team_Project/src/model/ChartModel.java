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

    private double[] gpa;
    private String[] courseName;
    private int[] credits;
    private String[] gpaKeyList = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"};
    private double[] gpaValueList = {4, 4, 3.7, 3.3, 3, 2.7, 2.3, 2, 1.7, 1.3, 1, 0.7, 0};
    private Map<String, Double> gpaMap = new HashMap<>();
    private final ArrayList<ActionListener> actionListenerList = new ArrayList<>();

    public ChartModel() {
        for (int i = 0; i < gpaKeyList.length; i++) {
            gpaMap.put(gpaKeyList[i], gpaValueList[i]);
        }
        /*
        for (Object s :gpaMap.keySet().toArray()) {
            System.out.println((String)s);
        }
        for (Object s :gpaMap.values().toArray()) {
            System.out.println((Double)s);
        }
         */
    }

    public void addActionListener(ActionListener l) {
        actionListenerList.add(l);
    }

    public void removeActionListener(ActionListener l) {
        actionListenerList.remove(l);
    }

    private void processEvent(ActionEvent e) {
        for (ActionListener listener : actionListenerList) {
            listener.actionPerformed(e);
        }
    }

    @Override
    public String toString() {
        return "ChartModel{" + "data=" + gpa + ", dataName=" + courseName + '}';
    }

    public void setChartData(String[] newDataName, double[] newData, int[] newCredit) {
        courseName = newDataName;
        gpa = newData;
        credits = newCredit;
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "test"));
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

    public double CreditsSum() {
        double creditsSum = 0.0;
        for (double d : credits) {
            creditsSum += d;
        }
        return creditsSum;
    }

    public double calculateAverageGpa() {
        double totalGpa = 0, totalCredit = 0;

        for (int i = 0; i < credits.length; i++) {
            totalGpa = totalGpa + (credits[i] * gpa[i]);
            totalCredit += credits[i];
        }
        return totalGpa / totalCredit;
    }
}

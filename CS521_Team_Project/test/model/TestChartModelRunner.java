/* 
 * Student Info: Name=Tsai-Chang Mai, ID=10010
 * Subject: CS521_Team_Project_Summer_2016
 * Author: Arvin 
 * Filename: TestChartModelRunner.java 
 * Date and Time: Jul 8, 2016 2:19:08 PM 
 * Project Name: CS521_Team_Project 
 */
package model;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Arvin
 */
public class TestChartModelRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestChartModel.class);
        for(Failure f : result.getFailures()){
            System.out.println(f.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}

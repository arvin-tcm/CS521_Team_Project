/* 
 * Student Info: Name=Tsai-Chang Mai, ID=10010
 * Subject: CS521_Team_Project_Summer_2016
 * Author: Arvin 
 * Filename: TestChartModel.java 
 * Date and Time: Jul 8, 2016 2:17:24 PM 
 * Project Name: CS521_Team_Project 
 */
package model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Arvin
 */
public class TestChartModel {

    public ChartModel sampleUnit = new ChartModel();
    public final int[] sampleCredits = {3, 2, 2, 1, 4};
    public final double[] sampleGPAs = {4, 2.7, 3, 1.7, 3.7};

    @Test
    public void testCreditsSum() {
        int result = 12;
        sampleUnit.setCredits(sampleCredits);
        assertEquals(result, (int) sampleUnit.creditsSum());
    }

    @Test
    public void testCalculateAverageGPA() {
        double result = 3.324;
        sampleUnit.setCredits(sampleCredits);
        sampleUnit.setGpa(sampleGPAs);
        assertEquals(result, (double)sampleUnit.calculateAverageGpa(), 0.001);
    }
}

/* 
 * Subject: CS521_Project_Summer_2016
 * Author: Arvin.TCM 
 * Filename: TimeStamp.java 
 * Date and Time: Jun 11, 2016 4:07:09 PM 
 * Project Name: CS521_Team_Project 
 */
package Domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class for time stamp
 *
 * @author Arvin
 */
public class TimeStamp implements TimeStampInterface, Serializable {

    private static final long serialVersionUID = 1L;

    private int year, month;
    private String semester;

    public TimeStamp(int year, int month) {
        this.year = year;
        this.month = month;
        calculateSeason();
    }

    public TimeStamp() {
        this(2016, 06);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
        calculateSeason();
    }

    public String getSemester() {
        return semester;
    }

    /**
     * Helping function to determine semester
     */
    private void calculateSeason() {
        if (month >= 2 && month <= 4) {
            semester = SEASON_SPRING;
        } else if (month >= 5 && month <= 7) {
            semester = SEASON_SUMMER;
        } else if (month >= 8 && month <= 10) {
            semester = SEASON_FALL;
        } else {
            semester = SEASON_WINTER;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.year;
        hash = 89 * hash + this.month;
        hash = 89 * hash + Objects.hashCode(this.semester);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TimeStamp other = (TimeStamp) obj;
        if (this.year != other.year) {
            return false;
        }
        if (this.month != other.month) {
            return false;
        }
        return Objects.equals(this.semester, other.semester);
    }

    @Override
    public String toString() {
        return "TimeStamp{" + "year=" + year + ", month=" + month + ", semester=" + semester + '}';
    }

}

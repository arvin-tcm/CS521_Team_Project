/* 
 * Subject: CS521_Project_Summer_2016
 * Author: Arvin.TCM 
 * Filename: GPARecord.java 
 * Date and Time: Jun 11, 2016 3:58:40 PM 
 * Project Name: CS521_Team_Project 
 */
package Domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class for GPA record
 *
 * @author Arvin
 */
public class GPARecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private long gpaID;
    private double gpa;
    private CourseRecord course;

    public GPARecord(double gpa, CourseRecord course) {
        this.gpa = gpa;
        this.course = course;
    }

    public GPARecord() {
        this(0.0, new CourseRecord());
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public CourseRecord getCourse() {
        return course;
    }

    public void setCourse(CourseRecord course) {
        this.course = course;
    }

    public long getGpaID() {
        return gpaID;
    }

    public void setGpaID(long gpaID) {
        this.gpaID = gpaID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (int) (this.gpaID ^ (this.gpaID >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.gpa) ^ (Double.doubleToLongBits(this.gpa) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.course);
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
        final GPARecord other = (GPARecord) obj;
        if (this.gpaID != other.gpaID) {
            return false;
        }
        if (Double.doubleToLongBits(this.gpa) != Double.doubleToLongBits(other.gpa)) {
            return false;
        }
        return Objects.equals(this.course, other.course);
    }

    @Override
    public String toString() {
        return "GPARecord{" + "gpaID=" + gpaID + ", gpa=" + gpa + ", course=" + course + '}';
    }

}

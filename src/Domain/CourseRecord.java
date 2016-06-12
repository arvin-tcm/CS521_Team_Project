/* 
 * Subject: CS521_Project_Summer_2016
 * Author: Arvin.TCM 
 * Filename: CourseRecord.java 
 * Date and Time: Jun 11, 2016 4:21:31 PM 
 * Project Name: CS521_Team_Project 
 */
package Domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class for Course information
 *
 * @author Arvin
 */
public class CourseRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private TimeStamp timeStamp;
    private String courseName, institutionName;
    private short creditCount;
    private long courseRecordID;

    public CourseRecord(TimeStamp timeStamp, String courseName, String institutionName, short creditCount) {
        this.timeStamp = timeStamp;
        this.courseName = courseName;
        this.institutionName = institutionName;
        this.creditCount = creditCount;
    }

    public CourseRecord() {
        this(new TimeStamp(), "unknown", "unknown", (short) 0);
    }

    public TimeStamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(TimeStamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public short getCreditCount() {
        return creditCount;
    }

    public void setCreditCount(short creditCount) {
        this.creditCount = creditCount;
    }

    public long getCourseRecordID() {
        return courseRecordID;
    }

    public void setCourseRecordID(long courseRecordID) {
        this.courseRecordID = courseRecordID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.timeStamp);
        hash = 83 * hash + Objects.hashCode(this.courseName);
        hash = 83 * hash + Objects.hashCode(this.institutionName);
        hash = 83 * hash + this.creditCount;
        hash = 83 * hash + (int) (this.courseRecordID ^ (this.courseRecordID >>> 32));
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
        final CourseRecord other = (CourseRecord) obj;
        if (this.creditCount != other.creditCount) {
            return false;
        }
        if (this.courseRecordID != other.courseRecordID) {
            return false;
        }
        if (!Objects.equals(this.courseName, other.courseName)) {
            return false;
        }
        if (!Objects.equals(this.institutionName, other.institutionName)) {
            return false;
        }
        return Objects.equals(this.timeStamp, other.timeStamp);
    }

    @Override
    public String toString() {
        return "CourseRecord{" + "timeStamp=" + timeStamp + ", courseName=" + courseName + ", institutionName=" + institutionName + ", creditCount=" + creditCount + ", courseRecordID=" + courseRecordID + '}';
    }

}

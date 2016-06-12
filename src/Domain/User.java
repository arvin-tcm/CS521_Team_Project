/* 
 * Subject: CS521_Project_Summer_2016
 * Author: Arvin.TCM 
 * Filename: User.java 
 * Date and Time: Jun 11, 2016 4:45:04 PM 
 * Project Name: CS521_Team_Project 
 */
package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arvin
 */
public class User {

    private long userID;
    private String name, passwd;
    private List<GPARecord> gpaList;

    public User(String name, String passwd, List<GPARecord> gpaList) {
        this.name = name;
        this.passwd = passwd;
        this.gpaList = gpaList;
    }

    public User(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
        this.gpaList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public List<GPARecord> getGpaList() {
        return gpaList;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    /**
     * function to get one GPA record object by provide course record object
     *
     * @param course
     * @return GPARecord object or null(not in the list)
     */
    public GPARecord getGpa(CourseRecord course) {
        try {
            GPARecord result = gpaList.get(findGPA(course));
            return result;
        } catch (IndexOutOfBoundsException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void setGpaList(List<GPARecord> gpaList) {
        this.gpaList = gpaList;
    }

    public void addGpa(GPARecord newRecord) {
        if (gpaList == null) {
            gpaList = new ArrayList<>();
        }
        gpaList.add(newRecord);

    }

    public void addGpa(List<GPARecord> newList) {
        if (gpaList == null) {
            gpaList = new ArrayList<>();
        }
        newList.stream().forEach((g) -> {
            gpaList.add(g);
        });
    }

    public void updateGpa(List<GPARecord> newList) {
        gpaList = newList;
    }

    /**
     * helping function to locate the index of an GPA record
     *
     * @param course
     * @return index of the target object or -1 for not exist
     */
    private int findGPA(CourseRecord course) {
        int index = 0;
        for (GPARecord g : gpaList) {
            if (g.getCourse().equals(course)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (int) (this.userID ^ (this.userID >>> 32));
        hash = 11 * hash + Objects.hashCode(this.name);
        hash = 11 * hash + Objects.hashCode(this.passwd);
        hash = 11 * hash + Objects.hashCode(this.gpaList);
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
        final User other = (User) obj;
        if (this.userID != other.userID) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.passwd, other.passwd)) {
            return false;
        }
        return Objects.equals(this.gpaList, other.gpaList);
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", name=" + name + ", passwd=" + passwd + ", gpaList=" + gpaList + '}';
    }

}

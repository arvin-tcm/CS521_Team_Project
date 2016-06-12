/* 
 * Subject: CS521_Project_Summer_2016
 * Author: Arvin.TCM 
 * Filename: OperationPackage.java 
 * Date and Time: Jun 11, 2016 6:26:31 PM 
 * Project Name: CS521_Team_Project 
 */
package Domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class of package will be send though Internet
 * @author Arvin
 */
public class OperationPackage implements Serializable {

    private static final long serialVersionUID = 1L;

    private int operationCode;
    private User user;
    private Boolean execute;

    public OperationPackage(int operationCode, User user) {
        this.operationCode = operationCode;
        this.user = user;
    }

    public OperationPackage(int operationCode) {
        this.operationCode = operationCode;
    }

    public boolean isExecute() {
        return execute;
    }

    public int getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(int operationCode) {
        this.operationCode = operationCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getExecute() {
        return execute;
    }

    public void setExecute(Boolean execute) {
        this.execute = execute;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.user);
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
        final OperationPackage other = (OperationPackage) obj;
        return Objects.equals(this.user, other.user);
    }

    @Override
    public String toString() {
        return "OperationPackage{" + "operationCode=" + operationCode + ", user=" + user + ", execute=" + execute + '}';
    }

}

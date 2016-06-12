/* 
 * Subject: CS521_Project_Summer_2016
 * Author: Arvin.TCM 
 * Filename: UserServiceInterface.java 
 * Date and Time: Jun 11, 2016 6:18:29 PM 
 * Project Name: CS521_Team_Project 
 */
package Service.RMIServer;

import Domain.OperationPackage;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Arvin
 */
public interface UserServiceInterface extends Remote {

    /**
     * Add new User to the DB
     *
     * @param operation
     * @return
     * @throws java.rmi.RemoteException
     */
    public OperationPackage addUser(OperationPackage operation) throws RemoteException;

    /**
     * Remove User by giving an User object
     *
     * @param operation
     * @return remove success or not
     * @throws java.rmi.RemoteException
     */
    public OperationPackage removeUser(OperationPackage operation) throws RemoteException;

    /**
     *
     * @param operation
     * @return success or not
     * @throws RemoteException
     */
    public OperationPackage insertGPARecord(OperationPackage operation) throws RemoteException;

    /**
     * 
     * @param operation
     * @return
     * @throws RemoteException 
     */
    public OperationPackage removeGPARecord(OperationPackage operation) throws RemoteException;

    /**
     * 
     * @param operation
     * @return
     * @throws RemoteException 
     */
    public OperationPackage searchGPARecord(OperationPackage operation) throws RemoteException;

    /**
     * 
     * @param operation
     * @return
     * @throws RemoteException 
     */
    public OperationPackage searchUser(OperationPackage operation) throws RemoteException;

}

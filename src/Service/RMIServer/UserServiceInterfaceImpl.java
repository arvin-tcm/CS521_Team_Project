/* 
 * Subject: CS521_Project_Summer_2016
 * Author: Arvin.TCM 
 * Filename: UserServiceInterfaceImpl.java 
 * Date and Time: Jun 11, 2016 6:19:03 PM 
 * Project Name: CS521_Team_Project 
 */
package Service.RMIServer;

import Domain.OperationPackage;
import java.rmi.RemoteException;

/**
 *
 * @author Arvin
 */
public class UserServiceInterfaceImpl implements UserServiceInterface {

    @Override
    public OperationPackage addUser(OperationPackage operation) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OperationPackage removeUser(OperationPackage operation) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OperationPackage insertGPARecord(OperationPackage operation) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OperationPackage removeGPARecord(OperationPackage operation) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OperationPackage searchGPARecord(OperationPackage operation) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OperationPackage searchUser(OperationPackage operation) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

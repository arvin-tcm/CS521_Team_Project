/* 
 * Subject: CS521_Project_Summer_2016
 * Author: Arvin.TCM 
 * Filename: RegisterWithRMIServer.java 
 * Date and Time: Jun 11, 2016 6:18:15 PM 
 * Project Name: CS521_Team_Project 
 */
package Service.RMIServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arvin
 */
public class RegisterWithRMIServer {

    public static void main(String[] args) {
        try {
            UserServiceInterface obj
                    = new UserServiceInterfaceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("UserServiceInterfaceImpl", obj);
            System.out.println("User server " + obj + " registered");

        } catch (RemoteException ex) {
            Logger.getLogger(RegisterWithRMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

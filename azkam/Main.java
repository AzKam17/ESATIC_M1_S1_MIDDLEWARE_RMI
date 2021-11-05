package azkam;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        try{
            LocateRegistry.createRegistry(9526);
            DataServImpl dataServ = new DataServImpl();
            String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/rmiPerson";
            System.out.println("==============================================================");
            System.out.println("========             DEMARRAGE RMI OK                 ========");
            Naming.rebind(url, dataServ);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

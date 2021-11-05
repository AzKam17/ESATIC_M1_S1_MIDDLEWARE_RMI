package azkam;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DataServInterface extends Remote {

    public String ajouterPersonne(Personne p) throws RemoteException, Exception;

    public String rechercheParId(int id) throws RemoteException;

    public String rechercheParPersonne(Personne p) throws RemoteException;

}

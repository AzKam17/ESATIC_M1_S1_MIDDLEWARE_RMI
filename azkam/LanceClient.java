package azkam;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class LanceClient {

  public static void main(String[] args) throws Exception {
    System.out.println("Lancement du client");
    if (System.getSecurityManager() == null) {
      System.setSecurityManager(new RMISecurityManager());
    }
    try {
      Remote r = Naming.lookup("rmi://localhost/TestRMI");
      //System.out.println(r);
      //if(r instanceof DataServImpl){

        System.out.println("Ajout des personnes");
        Personne p1 = new Personne(18, "AzKam");
        Personne p2 = new Personne(22, "Carl");
        Personne p3 = new Personne(30, "John");
        Personne p4 = new Personne(19, "Blé Serges");

        String s="";
        s = ((DataServInterface) r).ajouterPersonne(p1);
        System.out.println("Réponse : " + s);

        s = ((DataServInterface) r).ajouterPersonne(p2);
        System.out.println("Réponse : " + s);

        s = ((DataServInterface) r).ajouterPersonne(p3);
        System.out.println("Réponse : " + s);

        s = ((DataServInterface) r).ajouterPersonne(p4);
        System.out.println("Réponse : " + s);

        System.out.println("Recherche de la personne avec l'id : 2");
        s = ((DataServInterface) r).rechercheParId(2);
        System.out.println("Réponse : " + s);

        System.out.println("Recherche de la personne avec l'id : 1");
        s = ((DataServInterface) r).rechercheParId(1);
        System.out.println("Réponse : " + s);

        System.out.println("Recherche de la personne avec l'id : 3");
        s = ((DataServInterface) r).rechercheParId(3);
        System.out.println("Réponse : " + s);

        System.out.println("Recherche de la personne s'appelant John avec pour age 30");
        s = ((DataServInterface) r).rechercheParPersonne(p3);
        System.out.println("Réponse : " + s);

        System.out.println("Recherche de la personne s'appelant Blé Serges avec pour age 19");
        s = ((DataServInterface) r).rechercheParPersonne(p4);
        System.out.println("Réponse : " + s);

      //}
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (NotBoundException e) {
      e.printStackTrace();
    }
    System.out.println("Fin du client");
  }
}

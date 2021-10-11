package metier;

import java.util.*;
import metier.*;
import dao.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utilitaires.*;

public class Representant {
    

    /* propriétés privées */
     private int idRepresentant;
    private String Nom;
    private String Prenom;
    private Double caRepresentant;
    private List<Client>lesClients;
    
    
    public void setIdRepresentant(int idrep){
        this.idRepresentant=idrep;
    }
    
    public int getIdRepresentant(){
        return this.idRepresentant;
    }
    
    public void setNom(String nom){
        this.Nom=nom;
    }
    
    public String getNom(){
        return this.Nom;
    }
    
    
    public void setPrenom(String prenom){
        this.Prenom=prenom;
    }
    
    public String getPrenom(){
        return this.Prenom;
    }
    
    public void setCaRepresentant(Double carepres){
        this.caRepresentant=carepres;
    }
    
    public double getCaRepresentant(){
        return this.caRepresentant;
    }
    
    
    public List<Client> getLesClients() throws Exception{
        if (lesClients == null) {
            throw new Exception ("La liste des clients n'a pas été initialisée !");
        }
            return lesClients;
    }
    
    public void setLesClients(){

        this.lesClients = new ArrayList<Client>();
    }
    

    public Representant(int idRepresentant, String prenom, String nom, List<Client> lesCli) {
        /* Affectations */
        this.idRepresentant=idRepresentant;
        this.Prenom=prenom;
        this.Nom=nom;
        this.lesClients=lesCli;
    }
    
    
    
    public Representant() {
        this.lesClients = new ArrayList<Client>();
    }
    

    /**
     * Recherche un Client sur son id dans la 
     * liste des clients. 
     * Retourne le Client si trouvé, sinon retourne null
     * @param idClient
     * @return Client
     */
    
    
    
    public Client getClientById(int idClient) throws Exception {
        Client unClientTrouve = new Client(); 
            for(Client unClient: getLesClients()){
                if(unClient.getIdClient()==idClient){
                    unClientTrouve= unClient;
                }    
            }
        
        return unClientTrouve;   
    }
}
//Client unClient = new Client();
        //Representant unRepresentant = new Representant();
        //Representant unRepresentant = new Representant(100, "Paul", "Auchon", bdd.getClientsBdD());
        //for(Client unClient : unRepresentant.getClients()){
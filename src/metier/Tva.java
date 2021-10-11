package metier;

import java.util.*;

public class Tva {

    /* propriétés privées */
    private int idTva;
    private Double tauxTva;
    
    /* getters et setters */
    public void setIdTva(int idtva){
        this.idTva=idtva;
    }
    
    public int getIdTva(){
        return this.idTva;
    }
    
    public void setTauxTva(Double tauxtva){
        this.tauxTva=tauxtva;
    }
    
    public double getTauxTva(){
        return this.tauxTva;
    }
    
    public Tva(int idTva, double tauxTva) {
        this.idTva=idTva;
        this.tauxTva=tauxTva;
    }

    

}

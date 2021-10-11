package metier;

import java.util.*;

public class Categorie {

    /* propriétés privées */
    private int idCategorie;
    private String libCategorie;

    /* getters et setters */
    public void setIdCategorie(int idcat){
        this.idCategorie=idcat;
    }
    
    public int getIdCategorie(){
        return this.idCategorie;
    }
    
    public void setLibCategorie(String libcat){
        this.libCategorie=libcat;
    }
    
    public String getLibCategorie(){
        return this.libCategorie;
    }
    
    public Categorie(int idCategorie, String libCategorie) {
        /* Affectations */
        this.idCategorie=idCategorie;
        this.libCategorie=libCategorie;
    }


}

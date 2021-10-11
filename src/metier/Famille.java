package metier;

import java.util.*;

public class Famille {

    /* propriétés privées */
    private int idFamille;
    private int libFamille;

    /* getters et setters */
    public void setIdFamille(int idfam){
        this.idFamille=idfam;
    }
    
    public int getIdFamille(){
        return this.idFamille;
    }
    
    public void setLibFamille(int libfam){
        this.libFamille=libfam;
    }
    
    public int getLibFamille(){
        return this.libFamille;
    }
    public Famille(int idFamille, String libFamille) {
        /* Affectations */
        this.idFamille=idFamille;
        this.libFamille=this.libFamille;
    }



}

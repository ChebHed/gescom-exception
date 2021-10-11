package metier;

import java.util.*;

public class Article {

    /* propriétés privées */
    private int idArticle;
    private String designation;
    private Double caArticle;
    private int qteStock;
    private Double prix;
    private Famille famille;
    private Tva tva;

    public Article(String des) {
        this.designation=des;
    }

    /* getters et setters */
    public void setIdArticle(int idart){
        this.idArticle=idart;
    }
    
    public int getIdArticle(){
        return this.idArticle;
    }
    
    public void setDesignation(String designation){
        this.designation=designation;
    }
    
    public String getDesignation(){
        return this.designation;
    }
    
    public void setCaArticle(Double caart){
        this.caArticle=caart;
    }
    
    public Double getCaArticle(){
        return this.caArticle;
    }
    
    public void setQteStock(int qtestock){
        this.qteStock=qtestock;
    }
    
    public int getQteStock(){
        return this.qteStock;
    }
    
    public void setPrix(Double prix){
        this.prix=prix;
    }
    
    public Double getPrix(){
        return this.prix;
    }
    
    
    public void setTva(Tva latva){
        this.tva=latva;
    }
    
    public Tva getTva(){
        return this.tva;
    }
    
    public void setFamille(Famille uneFamille){
    this.famille=uneFamille;
}
    
    public Famille getFamille(){
        return this.famille;
    }
    
    
    public Article(int idArticle, String designation, int qteStock, double prix, Tva uneTva, Famille uneFamille) {
        /* Affectations */
        this.idArticle=idArticle;
        this.designation=designation;
        this.qteStock=qteStock;
        this.prix=prix;
        this.tva=uneTva;
        this.famille=uneFamille;
    }

}

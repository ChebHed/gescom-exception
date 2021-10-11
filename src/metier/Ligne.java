package metier;

import java.util.*;

public class Ligne {
   /* propriétés privées */
   private int qteCommande;
   private Article article;
   
   
   /* getters et setters */
   public void setQteCommande(int qtecomm){
       this.qteCommande=qtecomm;
   }
   
   public int getQteCommande(){
       return this.qteCommande;
   }

    public Ligne (Article unArticle, int qteCommande){
        /* Affectations */
        this.article=unArticle;
        this.qteCommande=qteCommande;
    }
    
    
    public Article getArticle(){
       return this.article; 
    }
    
    public void setArticle( Article unArticle){
        this.article=unArticle;
    }
}
package gescom;

import metier.*;
import dao.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import utilitaires.*;

public class Gescom {

    /* Déclaration de l'objet de type BdD */
    static BdD bdd;
    public static void main(String[] args) throws Exception {
        /* Instanciation de l'objet de type BdD */
        try{
        bdd = new BdD();}
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
         /*Déclaration et instanciation d'un objet de type Representant */
        Representant unRepresentant = new Representant(100, "Paul", "Auchon", bdd.getClientsBdD());
        int choix = menu();
        while (choix != 0) {
            switch (choix) {
                case 1:
                    listerClients(unRepresentant);
                    break;
                case 2:
                    afficherArticlesCommandes(unRepresentant);
                    break;
                case 3:
                    rechercherCommande(unRepresentant);
                    break;
                case 4:
                    ajouterCommande(unRepresentant);
                    afficherCommandesClient(unRepresentant);
                    break;
                case 5:
                    supprimerCommande(unRepresentant);
                    listerClients(unRepresentant);
                    break;
                case 6:
                    supprimerLigne(unRepresentant);
                    break;
                case 7:
                    afficherCaClient(unRepresentant);
                    break;
                case 8:
                    afficherCaClients(unRepresentant);
                    break;
            }
            choix = menu();
        }
    }

    private static int menu() {
        System.out.println("Menu général");
        System.out.println();
        System.out.println("1..Lister les clients et leurs commandes");
        System.out.println("2..Liste des articles commandés");
        System.out.println("3..Rechercher une commande");
        System.out.println("4..Ajouter une commande");
        System.out.println("5..Supprimer une commande");
        System.out.println("6..Supprimer une ligne d'une commande");
        System.out.println("7..Afficher le CA d'un client");
        System.out.println("8..Afficher le CA de tous les clients");
        
        System.out.println("0..Quitter");
        Scanner sc = new Scanner(System.in);
        System.out.println("Votre choix : ");
        int choix = sc.nextInt();
        return choix;
    }

    /**
     * Saisie de l'id du client à recherché, si trouvé
     * parcours de la liste des commande et pour chaque
     * commande, affiche la commande
     * sinon affiche client inexistant
     * @param unRepresentant 
     */
    private static void afficherCaClient(Representant unRepresentant) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez id client");
        int idClient = sc.nextInt();
        Client unClient = unRepresentant.getClientById(idClient);
        if(unClient!=null){
            unClient.cumulCA();
            System.out.println("CA : " + unClient.getCaClient() );

        }else{System.out.println("client inexistant");}
    }

    /**
     * Saisie de l'id du client à recherché, si trouvé
     * parcours de la liste des commande et pour chaque
     * commande, affiche la commande
     * sinon affiche client inexistant
     * @param unRepresentant 
     */
    private static void afficherCommandesClient(Representant unRepresentant) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez id client");
        int idClient = sc.nextInt();
        Client unClient = unRepresentant.getClientById(idClient);
        if(unClient!=null){
            for(Commande uneCommande: unClient.getLesCommandes()){
                 afficherCommande(uneCommande);
             }
        }else{System.out.println("client inexistant");}
        
    }

    /**
     * Parcours de la liste des clients et pour chaque client
     * affiche son id et sa raison sociale, puis parcours de
     * la liste des commandes du client et affiche chaque
     * commande
     * @param unRepresentant 
     */
    private static void listerClients(Representant unRepresentant) throws Exception {
        /* A compléter */
        for(Client unClient : unRepresentant.getLesClients()){//pour ce representant j'accede à sa liste de clients
            System.out.println(unClient.getIdClient() + " " + unClient.getRaisonSociale());
            for(Commande uneCommande : unClient.getLesCommandes()){//je vais chercher dans la classe Commande l'id et la date
                System.out.println("Commande : " + uneCommande.getIdCommande() + " du : " + uneCommande.getDate());
                for(Ligne uneLigne: uneCommande.getLesLignes()){//pour cette commande je vais chercher la liste de ligne
                    System.out.println(uneLigne.getArticle().getIdArticle()+ " " + uneLigne.getArticle().getDesignation() + " , " + uneLigne.getQteCommande());//id article et la désignation sont une case plus loin, la porte d'entrée c'est getArticles 
                }
            }
        }
        
    }

    /**
     * Saisie du numéro de la commande à suprimer,
     * parcours de la liste de tous les clients, si la commande  
     * est trouvée, la supprimer de la liste des commandes 
     * de ce client et arrêter le parcours.
     * @param unRepresentant 
     */
    private static void supprimerCommande(Representant unRepresentant) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez id comm");
        int idComm = sc.nextInt();
             for(Client leClient : unRepresentant.getLesClients()){
                 for(Commande uneCommande: leClient.getLesCommandes()){
                    if(uneCommande.getIdCommande()==idComm){
                        leClient.getLesCommandes().remove(uneCommande);
                        break;
                    }
                 }  
                   
            }
        listerClients(unRepresentant);
    
    }

    /**
     * Affiche la liste des articles commandés sans doublons.
     * Déclare et instancie une collection d'Article
     * Parcours de la liste des clients et pour chaque client
     * parcours de la liste de ses commandes et pour chaque 
     * commande parcours de la liste des lignes
     * Si la liste locale ne contient pas l'article de la ligne
     * en cours ,l'ajouter et afficher l'article
     * @param unRepresentant 
     */
    private static void afficherArticlesCommandes(Representant unRepresentant) throws Exception {
        List<String> desArticles = new ArrayList<String>();
        int taille = desArticles.size();
        
        
        for(Client unClient : unRepresentant.getLesClients()){
            for(Commande uneCommande : unClient.getLesCommandes()){
                for(Ligne uneLigne : uneCommande.getLesLignes()){
                        if(desArticles.contains(uneLigne.getArticle().getDesignation())){
                        
                        }
                        else{
                            desArticles.add(uneLigne.getArticle().getDesignation());
                            afficherArticle(uneLigne.getArticle());
                        }
                        
                    }
                
            }
            
        }
        
        
        
    }

    /**
     * Affiche l'id, la désignation, la famille et la TVA
     * de l'article passé en paramètre
     * @param unArticle 
     */
    private static void afficherArticle(Article unArticle) {
            System.out.println("Article : " + unArticle.getIdArticle() + " " + unArticle.getDesignation() + " Famille : " + unArticle.getFamille().getLibFamille() + " , TVA " + unArticle.getTva().getTauxTva());
        }
        

    /**
     * Parcours de la liste des clients et pour chaque client, 
     * appel de la méthode cumulCA() et affichage de l'id
     * de la raison sociel et du CA du client
     * @param unRepresentant 
     */
    private static void afficherCaClients(Representant unRepresentant) throws Exception {
        //double cumulCaClients=0;
        Scanner sc = new Scanner(System.in);            
        for(Client unClient: unRepresentant.getLesClients()){
            unClient.cumulCA();
            System.out.println(unClient.getIdClient() + unClient.getRaisonSociale() + " CA : " + unClient.getCaClient() );
        }
        
    }
    

    /**
     * Recherche la commande d'un client.
     * saisie de l'id du client, récupération
     * du client, s'il existe : saisie de l'id
     * de la commande, récupération de la commande
     * si elle existe afficher la commande, sinon 
     * afficher commande inexistante, idem pour 
     * le client
     * @param unRepresentant 
     */
    private static void rechercherCommande(Representant unRepresentant) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Entrez idClient");
        int idClient = sc.nextInt();
        Client unClient = new Client();
        unClient = unRepresentant.getClientById(idClient);
        if(unClient!=null){
            System.out.println("Entrez id commande");
            int idCommande = sc.nextInt();
            Commande uneCommande = new Commande();
            uneCommande = unClient.getCommandeById(idCommande);

                if(unClient!=null){
                    afficherCommandesClient(unRepresentant);
                }else{System.out.println("client inexistant");}
            
            }else{System.out.println("commande inexistante");}
        
        
    }
    
    
    /**
     * Supprimer une ligne de commande :
     * Saisie de l'id du client et récupération du client
     * S'il n'existe pas afficher client inexistant, 
     * s'il existe : saisie de l'id de la commande
     * récupération de la commande, si elle n'existe pas
     * afficher commande inexistante, si elle existe
     * saisie de l'id de l'article, rechercher la ligne
     * ayant l'id de l'article, si la ligne existe la supprimer
     * sinon afficher que l'article ne figure pas dans cette commande
     * @param unRepresentant 
     */
    private static void supprimerLigne(Representant unRepresentant) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez idClient");
        int idClient = sc.nextInt();
        Client unClient = new Client();
        unClient = unRepresentant.getClientById(idClient);
        if(unClient!=null){
            
            System.out.println("Entrez id commande");
            int idCommande = sc.nextInt();
            Commande uneCommande = new Commande();
            uneCommande = unClient.getCommandeById(idCommande);
            if(uneCommande!=null){
                
                System.out.println("Entrez id Article");
                int idArticle = sc.nextInt();
                Article art = bdd.getArticleBdD(idArticle);
                if(art!=null){
                    Ligne ligne = uneCommande.chercherLigne(art);
                    unClient.getCommandeById(idCommande).getLesLignes().remove(ligne);
                    
                }else{System.out.println("article inexistant");}
                
            }else{System.out.println("commande inexistante");}
            
        }else{System.out.println("client inexistant");}
    }

    /**
     * Ajoute une commande à un client.
     * Saisie de l'id du client et recherche du client
     * S'il nexiste pas afficher client inexistant
     * S'il existe : saisie de l'id et de la date de commande
     * création de la commande et ajout à la liste des 
     * commandes du client, saisie de l'id de l'article
     * et de la qte commandée, ajout de la ligne à la
     * commande
     * Rappel : la classe bdd propose une méthode de recherche d'un article sur son id
     * @param unRepresentant 
     */
    private static void ajouterCommande(Representant unRepresentant) throws Exception {
        int idClient;
        int idCommande;
        int idArticle;
        int qteComm;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez id client");
        idClient = sc.nextInt();
        Client unClient = unRepresentant.getClientById(idClient);
        if(unClient==null){
            System.out.println("client inexistant");
        }else{
                System.out.println("Entrez id commande");
                idCommande = sc.nextInt();
                String dateCommande = Clavier.saisie_string("Date de commande : ");
             
                System.out.println("Entrez id Article");
                idArticle=sc.nextInt();
                System.out.println("Entrez la qte comm");
                qteComm=sc.nextInt();
                Article art = bdd.getArticleBdD(idArticle);//new Article(idArticle, dateCommande, qteComm, prix, t, f);
                Commande uneCommande = new Commande(idCommande,  Outils.stringToDate(dateCommande));
                uneCommande.ajouterLigne(art, qteComm);
                unClient.ajouterCommande(uneCommande);
                afficherCommande(uneCommande);
                
                
            }    
    }
        
       
        
    
    /**
     * Affiche l'id, la date de la commande,
     * puis affiche la liste des lignes : id article
     * désignation et qte commandée
     * @param uneCommande 
     */
    private static void afficherCommande(Commande uneCommande) throws Exception {
       
        System.out.println("Commande : " + uneCommande.getIdCommande() + " du : " + uneCommande.getDate());
                for(Ligne uneLigne : uneCommande.getLesLignes()){
                            System.out.println("Article : " + uneLigne.getArticle().getIdArticle() + " " + uneLigne.getArticle().getDesignation() + " Quantite " + uneLigne.getQteCommande());
                        }
            }
            
        
    

}


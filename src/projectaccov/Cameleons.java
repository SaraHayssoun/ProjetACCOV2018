/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectaccov;

/**
 *
 * @author Sara
 */
public class Cameleons implements Runnable {

    public Mail mail;
    public IdCameleon id; //chaque cameneon est represente par une couleur unique

    public Couleur maCouleur, couleurAutreCameleon;

    public Cameleons(Mail mail, IdCameleon id, Couleur couleur) {
        this.mail = mail;
        this.id = id;
        this.maCouleur = couleur;
    }

    /**
     * Cette methode est utilise pour donner information sur l'etat de cameneos
     * avec information sur le cameneos
     *
     * @param infoCourant cette parametre est pour donner l'etat courant de
     * cameneos
     */
    public void donnerInformation(String infoCourant) {
        System.out.println("Mon Identificateur est " + this.id + " Mon Couleur est: " + this.maCouleur + " et " + infoCourant);
    }

    /**
     * Cette methode est utilise dans l'etat quand le cameneos mange
     */
    public void manger() {
        this.donnerInformation("Je suis entrain de manger");
    }

    /**
     * Cette methode est utilise dans l'etat quand le cameneos entraine
     */
    public void entrainer() {
        this.donnerInformation("Je suis entrain d'entrainer");
    }

    /**
     * Cette methode est utilise dans l'etat quand le cameneos aller au mail
     */
    public void allerAuMail() {
        this.donnerInformation("Je veux aller au mail");
    }

    /**
     * Cette methode est utilise dans l'etat quand le cameneos faire un mutation
     */
    public void faireMutation() {
        this.donnerInformation("je veux faire une mutation");
        this.couleurAutreCameleon = mail.Cooperation(this.id, maCouleur);
        this.maCouleur = new Couleur(this.maCouleur.mutation(id,new Couleur( maCouleur.couleur)));
        this.donnerInformation("la mutation est finie");
    }

    /**
     * Les actions que chaque cameneon fait
     */
    @Override
    public void run() {
        while (true) {
            manger();
            entrainer();
            allerAuMail();
            faireMutation();
        }
    }
}

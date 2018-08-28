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
public class Mail {

    public Couleur premiereCouleur, deuxiemeCouleur;//Les couleur des cameleons partenaires
    public Boolean premiereAppelCameleon = true;//l'arrive de premiere Thread cameneon
    public Boolean fautAttendre = false;//flag pour savoir quand le mail contient deux cameneon

    /**
     * Cette methode est utilise pour faire le cooperation entre les cameneon
     *
     * @param id
     * @param couleur
     * @return 
     */
    public synchronized Couleur Cooperation(IdCameleon id, Couleur couleur) {
        Couleur nouveauCouleur;
        //Fait tout les autre cameneon attendre si le mail contient deux cameneon partenaire
        while (fautAttendre) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        if (this.premiereAppelCameleon) {
            this.premiereCouleur = couleur;
            this.premiereAppelCameleon = false;
            while (!this.premiereAppelCameleon) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
            this.fautAttendre = false;
            nouveauCouleur = this.deuxiemeCouleur;
            notifyAll();
        } else {
            this.deuxiemeCouleur = couleur;
            nouveauCouleur = this.premiereCouleur;
            this.premiereAppelCameleon = true;
            this.fautAttendre = true;
            notifyAll();
        }
        return nouveauCouleur;
    }
}

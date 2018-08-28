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
public class Couleur {

    String[] couleurs = {"Bleu", "Jaune", "Rouge"};
    String couleur, couleur1, couleur2;
    private boolean premierCameleon = true;
    private boolean attendre;

    public Couleur(String maCouleur) {
        this.couleur = maCouleur;
    }

    public synchronized String mutation(IdCameleon id, Couleur couleur) {
        String resultat;
        while (attendre) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        if (premierCameleon) {
            couleur1 = couleur.couleur;
            premierCameleon = false;
            while (!premierCameleon) {
                try {
                    // il faut attendre le deuxieme cameleon
                    wait();
                } catch (InterruptedException e) {
                }
            }
            attendre = false;
            resultat = couleur2;
            notifyAll();
        } else {
            // second cameleon
            couleur2 = couleur.couleur;
            resultat = couleur1;
            premierCameleon = true;
            attendre = true;
            notifyAll();
        }
        return resultat;
    }
}

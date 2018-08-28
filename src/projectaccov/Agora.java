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
public class Agora {

    private Couleur ACouleur, BCouleur;
    private boolean premierAppel = true;
    private boolean doitAtendre = false;

    public synchronized Couleur Cooperation(IdCameleon x, Couleur C) {
        Couleur resultat;

        while (doitAtendre) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        if (premierAppel) {
            ACouleur = C;
            premierAppel = false;
            while (!premierAppel) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            doitAtendre = false;
            resultat = BCouleur;
            notifyAll();
        } else {
            BCouleur = C;
            resultat = ACouleur;
            premierAppel = true;
            doitAtendre = true;
            notifyAll();
        }
        return resultat;
    }
}

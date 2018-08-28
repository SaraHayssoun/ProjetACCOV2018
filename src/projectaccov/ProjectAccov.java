/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectaccov;

import java.util.Random;

/**
 *
 * @author Sara
 */
public class ProjectAccov {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] colors = {"Bleu", "Jaune", "Rouge"};
        for (int i = 0; i < 10; i++) {
            Cameleons c = new Cameleons(new Mail(),new IdCameleon(i), new Couleur(colors[new Random().nextInt(colors.length)]));
            new Thread(c).start();
        }
    }
}

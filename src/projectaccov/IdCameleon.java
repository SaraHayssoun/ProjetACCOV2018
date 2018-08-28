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
public class IdCameleon {

    private final int id;

    public IdCameleon(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cameleon-" + this.id;
    }

}

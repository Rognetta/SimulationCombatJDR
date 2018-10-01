/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Random;

/**
 *
 * @author Aurelio
 */
public class Combat {

    public int lancerD20() {
        int res;
        Random rand = new Random();
        res = rand.nextInt(19) + 1;
        return res;
    }

    public int lancerD10() {
        int res;
        Random rand = new Random();
        res = rand.nextInt(9) + 1;
        return res;
    }

    public int dommage(Personnage Fighter) {
        int res;
        Random rand = new Random();
        int d = rand.nextInt(Fighter.getDégats() - 1) + 1;
        res = Fighter.getDégats_bonus() + Fighter.getBonus_dégatArme() + d;
        //System.out.println("Dommage = " + res);
        return res;
    }

    public void degat(Personnage Fighter, int dommage) {
        if (Fighter.getTypeDégat() == null) {
            System.out.println("There is a problem");
        } else {
            switch (Fighter.getTypeDégat()) {
                case "tranchant":
                    if (dommage > Fighter.getArmureTranchant()) {
                        //il est possible qu'il y ait des conflits si je récupère une valeur
                        //dans un set de la même valeur, donc je vais mettre un intermédiaire
                        int pvActuel = Fighter.getPv();
                        Fighter.setPv(pvActuel - dommage + Fighter.getArmureTranchant());
                    }
                    break;
                case "contondant":
                    if (dommage > Fighter.getArmureContondant()) {
                        //il est possible qu'il y ait des conflits si je récupère une valeur
                        //dans un set de la même valeur, donc je vais mettre un intermédiaire
                        int pvActuel = Fighter.getPv();
                        Fighter.setPv(pvActuel - dommage + Fighter.getArmureContondant());
                    }
                    break;
                case "percant":
                    if (dommage > Fighter.getArmurePercant()) {
                        //il est possible qu'il y ait des conflits si je récupère une valeur
                        //dans un set de la même valeur, donc je vais mettre un intermédiaire
                        int pvActuel = Fighter.getPv();
                        Fighter.setPv(pvActuel - dommage + Fighter.getArmurePercant());
                    }
                    break;
                default:
                    System.out.println("There might be a problem: " + Fighter.getTypeDégat());
                    break;
            }
        }
    }
    
    public int Combat() {
    int a = 0;
    return a;
}
    
}

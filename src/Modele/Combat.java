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

    public int armure(Personnage Fighter, int dommage) {
        int pvActuel = Fighter.getPv();
        if (Fighter.getTypeDégat() == null) {
            System.out.println("There is a problem");
        } else {
            switch (Fighter.getTypeDégat()) {
                case "tranchant":
                    if (dommage > Fighter.getArmureTranchant()) {
                        pvActuel = pvActuel - dommage + Fighter.getArmureTranchant();
                    }
                    break;
                case "contondant":
                    if (dommage > Fighter.getArmureContondant()) {
                        pvActuel = pvActuel - dommage + Fighter.getArmureContondant();
                    }
                    break;
                case "percant":
                    if (dommage > Fighter.getArmurePercant()) {
                        pvActuel = pvActuel - dommage + Fighter.getArmurePercant();
                    }
                    break;
                default:
                    System.out.println("There might be a problem: " + Fighter.getTypeDégat());
                    break;
            }
        }
        return pvActuel;
    }
    
    public int scoreCombat(Personnage Fighter){
        int res;
        res = Fighter.getMélée() + Fighter.getForce();
        return res;
    }
    
    public int[] combat(Personnage C1, Personnage C2) {
        int sc1 = scoreCombat(C1);
        int sc2 = scoreCombat(C2);
        int pvRestant1 = C1.getPv();
        int pvRestant2 = C2.getPv();
        
        if (sc1 == sc2){
            int d1 = dommage(C1);
            int d2 = dommage(C2);
            pvRestant1 = armure(C1, d2);
            pvRestant2 = armure(C2, d1);
        }
        else if (sc1 < sc2){
            int d2 = dommage(C2);
            pvRestant1 = armure(C1, d2);
        }
        else if (sc1 > sc2) {
            int d1 = dommage(C1);
            pvRestant2 = armure(C2, d1);
        }
        
        int tab[] = {pvRestant1,pvRestant2};
        return tab;
    }

}

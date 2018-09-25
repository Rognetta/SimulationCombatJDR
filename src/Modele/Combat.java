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
    
    public int lancerD20()
    {
        int res;
        Random rand = new Random();
        res = rand.nextInt(19) + 1;
        return res;
    }
    
    public int lancerD10()
    {
        int res;
        Random rand = new Random();
        res = rand.nextInt(9) + 1;
        return res;
    }
    
    public int dommage(Personnage Fighter)
    {
        int res;
        Random rand = new Random();
        int d = rand.nextInt(Fighter.dégats-1) + 1;
        res = Fighter.dégats_bonus + d;
        System.out.println("Dommage = " + res);
        return res;
    }
    
    /*public void degat(Personnage Fighter, int dommage)
    {
        if(null == Fighter.typeDégat)
        {
            //Fighter.setpv(dommage);
            System.out.println("There is a problem");
        }
        else switch (Fighter.typeDégat) {
            case "tranchant":
                if(dommage > this.armureTranchant)
                {
                    this.pv -= dommage - this.armureTranchant;
                }   break;
            case "contondant":
                if(dommage > this.armureContondant)
                {
                    this.pv -= dommage - this.armureContondant;
                }   break;
            case "percant":
                if(dommage > this.armurePercant)
                {
                    this.pv -= dommage - this.armurePercant;
                }   break;
            default:
                this.pv -= dommage;
                System.out.println("There might be a problem: " + typearme);
                break;
        }*/
    
}

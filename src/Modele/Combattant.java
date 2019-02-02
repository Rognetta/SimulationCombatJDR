package Modele;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aurelio
 */

import java.util.Random;

public class Combattant {
    
    private int score;
    private int pv;
    private int dommage;
    private int dommageBonus;
    private int chance;
    private String typearme;
    private int armureTranchant;
    private int armureContondant;
    private int armurePercant;
    private String nom;
    private String equipe;

    public Combattant(int score, int pv, int dommage, int dommageBonus, int chance, String typearme, int armureTranchant, int armureContondant, int armurePercant, String nom, String equipe) {
        this.score = score;
        this.pv = pv;
        this.dommage = dommage;
        this.dommageBonus = dommageBonus;
        this.chance = chance;
        this.typearme = typearme;
        this.armureTranchant = armureTranchant;
        this.armureContondant = armureContondant;
        this.armurePercant = armurePercant;
        this.nom = nom;
        this.equipe = equipe;
    }
    
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
    
    public int dommage()
    {
        int res;
        Random rand = new Random();
        int d = rand.nextInt(this.dommage-1) + 1;
        res = this.dommageBonus + d;
        System.out.println("Dommage = " + res);
        return res;
    }
    
    public void degat(int dommage, String typearme)
    {
        if(null == typearme)
        {
            this.pv -= dommage;
            System.out.println("There is a problem");
        }
        else switch (typearme) {
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
        }
    }
    
    public int combat()
    {
        int res;
        if(this.chance>0)
        {
            res = this.lancerD20();
            if(res%2 == 1)
            {
                res += 3;
                this.chance--;
            }
        }
        else
        {
            res = this.lancerD10();
        }
        res += this.score;
        return res;
    }
       
    public int getPv() {
        return pv;
    }

    public String getTypearme() {
        return typearme;
    }
}

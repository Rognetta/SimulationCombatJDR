/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Combattant;

/**
 *
 * @author Aurelio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        /*
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
        private String équipe;
        */
        // Bite
        //int fin =0;
        float percentc1 = 0;
        float percentc2 = 0;
        
        for(int i = 0; i<1000; i++)
        {
            int fin = 0;
            Combattant c1 = new Combattant(15, 30, 12, 3, 3, "tranchant", 3, 3, 3, "Shub", "Ylissia");
            Combattant c2 = new Combattant(15, 30, 12, 3, 3, "tranchant", 3, 3, 3, "Sandra", "Pilio");
            System.out.println("PV de c1 :" + c1.getPv());
            System.out.println("PV de c2 :" + c2.getPv());
             while(fin == 0)
            {
                int a = c1.combat();
                int b = c2.combat();

                if(a < b)
                {
                    c1.degat(c2.dommage(), c2.getTypearme());
                    System.out.println("c2 gagne le round");
                }
                else if(a > b)
                {
                    c2.degat(c1.dommage(), c1.getTypearme());
                    System.out.println("c1 gagne le round");
                }
                else
                {
                    c1.degat(c2.dommage(), c2.getTypearme());
                    c2.degat(c1.dommage(), c1.getTypearme());
                    System.out.println("egalite");
                }

                System.out.println("PV de c1 :" + c1.getPv());
                System.out.println("PV de c2 :" + c2.getPv());

                if(c1.getPv()<1)
                {
                    fin = 1;
                    percentc1++;
                    System.out.println("c2 a gagné");
                }
                else if(c2.getPv()<1)
                {
                    fin = 2;
                    percentc2++;
                    System.out.println("c1 a gagné");
                }
            }
        }
        System.out.println("Pourcentage de c1 = " + percentc1/10 + "plus ou moins 2 pourcent");
        System.out.println("Pourcentage de c2 = " + percentc2/10 + " plus ou moins 2 pourcent");
    }
}

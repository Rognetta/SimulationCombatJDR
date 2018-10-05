/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

//import Modele.Combattant;
import Modele.Personnage;
import Modele.Combat;
import Modele.CharaGenerator;

/**
 *
 * @author Aurelio
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CharaGenerator Gen = new CharaGenerator();
        Combat Fight = new Combat();
        Personnage C1 = new Personnage();
        Personnage C2 = new Personnage();
        C1 = Gen.PaysanGen();
        C2 = Gen.PaysanGen();
        int count1 = 0;
        int count2 = 0;
        Personnage C1copie = new Personnage();
        Personnage C2copie = new Personnage();
        C1copie = C1;
        C2copie = C2;
        
        int victory = 0;
        for (int i = 0; i < 1000; i++) {
            victory = Fight.combat(C1, C2);
            if (victory == 1) {
                count1++;
            }
            else if (victory == 2) {
                count2++;
            }
            
            C1 = C1copie;
            C2 = C2copie;
        }

        System.out.println("Pourcentage de c1 = " + count1/10f + " plus ou moins 2 pourcent");
        System.out.println("Pourcentage de c2 = " + count2/10f + " plus ou moins 2 pourcent");
        
    }
}

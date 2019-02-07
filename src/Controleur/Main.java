/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

//import Modele.Combattant;
import Database.Database;
import Modele.Personnage;
import Modele.Combat;
import Modele.CharaGenerator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        for (int i = 0; i < 1000; i++) {
            int victory = 0;
            victory = Fight.combat(C1, C2);
            if (victory == 1) {
                count1++;
            }
            else if (victory == 2) {
                count2++;
            }
            C1.fullHeal();
            C2.fullHeal();
        }

        System.out.println("Pourcentage de c1 = " + count1/10f + " plus ou moins 2 pourcent");
        System.out.println("Pourcentage de c2 = " + count2/10f + " plus ou moins 2 pourcent");
        

//        Database database = new Database();
//        try {
//            database.readFromFile(database.getActualFile());
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("Database size : " + database.getM_database().size());
//        database.addToDatabasa(Gen.PaysanGen());
//        System.out.println("Database size after insert : " + database.getM_database().size());
//        try {
//            database.writeToFile(database.getActualFile(), database.getM_database());
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}

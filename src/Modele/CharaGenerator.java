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
public class CharaGenerator {

    public CharaGenerator() {
    }
    
    
    public int NbToNbGen(int from, int to) {
    int res=0;
    Random rand = new Random();
    res = rand.nextInt(to-1) + from;
    return res;
}
    
    public Personnage PaysanGen()
    {
        int AttributMin = 2;
        int AttributMax = 5;
        int CompMin = 0;
        int CompMax = 4;
        int chance = 3;
        int eclat =  0;
        int coeffRegenPV = 2;
        int coeffRegenMana = 2;
        int degats = 4;
        int BDA=0;
        String typeDegats = "tranchant";
        int AP = 0;
        int AC =0;
        int AT = 0;
        
        Personnage Paysan= new Personnage(chance, eclat, NbToNbGen(AttributMin, AttributMax), 
                NbToNbGen(AttributMin, AttributMax), NbToNbGen(AttributMin, AttributMax), 
                NbToNbGen(AttributMin, AttributMax), NbToNbGen(AttributMin, AttributMax), 
                NbToNbGen(AttributMin, AttributMax), coeffRegenPV, coeffRegenMana, 
                NbToNbGen(CompMin, CompMax), NbToNbGen(CompMin, CompMax), 
                NbToNbGen(CompMin, CompMax), NbToNbGen(CompMin, CompMax), 
                NbToNbGen(CompMin, CompMax), NbToNbGen(CompMin, CompMax), degats, 
                BDA, typeDegats, AP, AC, AT);
        return Paysan;
    }
    
    
    
}

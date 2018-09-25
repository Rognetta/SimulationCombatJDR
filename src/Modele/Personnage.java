/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Thomas
 */
public class Personnage {
    
    // -- Attributs
    protected int chance;
    protected int chance_max;
    protected int force;
    protected int force_bonus;
    protected int endurance;
    protected int endurance_bonus;
    protected int agilité;
    protected int agilité_bonus;
    protected int intelligence;
    protected int intelligence_bonus;
    protected int trempe;
    protected int trempe_bonus;
    protected int social;
    protected int social_bouns;
    protected int pv;
    protected int pv_max;
    protected int coeffRegenPv;
    protected int mana;
    protected int manaMax;
    protected int coeffRegenMana;
    protected int dégats_bonus; // calcul auto
    
    //-- compétences
    protected int armeDistance;
    protected int armeDistance_bonus;
    protected int discretion;
    protected int discretion_bonus;
    protected int dressage;
    protected int dressage_bonus;
    protected int mélée;
    protected int mélée_bonus;
    protected int nage;
    protected int nage_bonus;
    protected int premiersSoin;
    protected int premiersSoin_bonus;
    protected int coercition; // calcul auto
    protected int coercition_bonus;
    protected int mouvement; // calcul auto
    protected int mouvement_bonus;
    protected int perception; // calcul auto
    protected int perception_bonus;
    protected int persuation; // calcul auto
    protected int persuation_bonus;
    protected int volonté; // calcul auto
    protected int volonté_bonus;
    
    // -- 
    protected int dégats;
    protected String typeDégat;
    protected int armurePercant;
    protected int armureContondant;
    protected int armureTranchant;
    
    //--! A prevoir
    // armure mutation
    // système equivalent toggle des differentes pièces d'armures

    public Personnage() {
    }
    
    
}

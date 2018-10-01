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
    protected int éclat;
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
    protected int social_bonus;
    protected int pv; // = pv_max à la création
    protected int pv_max; // =E*4+T*2
    protected int coeffRegenPv;
    protected int mana; // = mana_max à la création
    protected int manaMax; // = T*4+I*2
    protected int coeffRegenMana;
    protected int dégats_bonus; // = F-4 si F<=5 ; =F-5 sinon
    
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
    protected int coercition; // =arrondiSup(F*2+S)
    protected int coercition_bonus;
    protected int mouvement; // =arrondiSup(A*2+E)
    protected int mouvement_bonus;
    protected int perception; // =arrondiSup(I*2+A)
    protected int perception_bonus;
    protected int persuasion; // =arrondiSup(S*2+I)
    protected int persuasion_bonus;
    protected int volonté; // =arrondiSup(T*2+E)
    protected int volonté_bonus;
    
    // -- equipements
    protected int dégats;
    protected int bonus_dégatArme;
    protected String typeDégat;
    protected int armurePercant;
    protected int armureContondant;
    protected int armureTranchant;
    
    //--! A prevoir
    // armure mutation
    // système equivalent toggle des differentes pièces d'armures

    public Personnage() {
    }

    public Personnage(int chance, int éclat, int force, int endurance, 
            int agilité, int intelligence, int trempe, int social, 
            int coeffRegenPv, int coeffRegenMana, int armeDistance, 
            int discretion, int dressage, int mélée, int nage, int premiersSoin, 
            int dégats, int bonus_dégatArme, String typeDégat, int armurePercant, 
            int armureContondant, int armureTranchant) {
        this.chance = chance;
        this.chance_max = chance;
        this.éclat = éclat;
        this.force = force;
        this.force_bonus = 0;
        this.endurance = endurance;
        this.endurance_bonus = 0;
        this.agilité = agilité;
        this.agilité_bonus = 0;
        this.intelligence = intelligence;
        this.intelligence_bonus = 0;
        this.trempe = trempe;
        this.trempe_bonus = 0;
        this.social = social;
        this.social_bonus = 0;
        this.pv = (this.endurance+this.endurance_bonus)*4 + (this.trempe+this.trempe_bonus)*2;
        this.pv_max = this.pv;
        this.coeffRegenPv = coeffRegenPv;
        this.mana = (this.trempe+this.trempe_bonus)*4 + (this.intelligence+this.intelligence_bonus)*2;
        this.manaMax = this.mana;
        this.coeffRegenMana = coeffRegenMana;
        switch(force) {
            case 1:this.dégats_bonus = -3;
            break;
            case 2:this.dégats_bonus = -2;
            break;
            case 3:this.dégats_bonus = -1;
            break;
            case 4:this.dégats_bonus = 0;
            break;
            case 5:this.dégats_bonus = 1;
            break;
            case 6:this.dégats_bonus = 1;
            break;
            case 7:this.dégats_bonus = 2;
            break;
            case 8:this.dégats_bonus = 3;
            break;
            case 9:this.dégats_bonus = 4;
            break;
            case 10:this.dégats_bonus = 5;
            break;
            default:
                break;
        }
        this.armeDistance = armeDistance;
        this.armeDistance_bonus = 0;
        this.discretion = discretion;
        this.discretion_bonus = 0;
        this.dressage = dressage;
        this.dressage_bonus = 0;
        this.mélée = mélée;
        this.mélée_bonus = 0;
        this.nage = nage;
        this.nage_bonus = 0;
        this.premiersSoin = premiersSoin;
        this.premiersSoin_bonus = 0;
        this.coercition = Math.round((this.force+this.force_bonus)*2+(this.social+this.social_bonus));
        this.coercition_bonus = 0;
        this.mouvement = 0; // a compléter
        this.mouvement_bonus = 0;
        this.perception = 0; // a compléter
        this.perception_bonus = 0;
        this.persuasion = 0; // a compléter
        this.persuasion_bonus = 0;
        this.volonté = 0; // a compléter
        this.volonté_bonus = 0;
        this.dégats = dégats;
        this.bonus_dégatArme = bonus_dégatArme;
        this.typeDégat = typeDégat;
        this.armurePercant = armurePercant;
        this.armureContondant = armureContondant;
        this.armureTranchant = armureTranchant;
    }

    public Personnage(int chance, int chance_max, int éclat, int force, 
            int force_bonus, int endurance, int endurance_bonus, int agilité, 
            int agilité_bonus, int intelligence, int intelligence_bonus, 
            int trempe, int trempe_bonus, int social, int social_bonus, int pv, 
            int pv_max, int coeffRegenPv, int mana, int manaMax, 
            int coeffRegenMana, int dégats_bonus, int armeDistance, 
            int armeDistance_bonus, int discretion, int discretion_bonus, 
            int dressage, int dressage_bonus, int mélée, int mélée_bonus, 
            int nage, int nage_bonus, int premiersSoin, int premiersSoin_bonus, 
            int coercition, int coercition_bonus, int mouvement, 
            int mouvement_bonus, int perception, int perception_bonus, int persuasion, int persuasion_bonus, int volonté, int volonté_bonus, int dégats, int bonus_dégatArme, String typeDégat, int armurePercant, int armureContondant, int armureTranchant) {
        this.chance = chance;
        this.chance_max = chance_max;
        this.éclat = éclat;
        this.force = force;
        this.force_bonus = force_bonus;
        this.endurance = endurance;
        this.endurance_bonus = endurance_bonus;
        this.agilité = agilité;
        this.agilité_bonus = agilité_bonus;
        this.intelligence = intelligence;
        this.intelligence_bonus = intelligence_bonus;
        this.trempe = trempe;
        this.trempe_bonus = trempe_bonus;
        this.social = social;
        this.social_bonus = social_bonus;
        this.pv = pv;
        this.pv_max = pv_max;
        this.coeffRegenPv = coeffRegenPv;
        this.mana = mana;
        this.manaMax = manaMax;
        this.coeffRegenMana = coeffRegenMana;
        this.dégats_bonus = dégats_bonus;
        this.armeDistance = armeDistance;
        this.armeDistance_bonus = armeDistance_bonus;
        this.discretion = discretion;
        this.discretion_bonus = discretion_bonus;
        this.dressage = dressage;
        this.dressage_bonus = dressage_bonus;
        this.mélée = mélée;
        this.mélée_bonus = mélée_bonus;
        this.nage = nage;
        this.nage_bonus = nage_bonus;
        this.premiersSoin = premiersSoin;
        this.premiersSoin_bonus = premiersSoin_bonus;
        this.coercition = coercition;
        this.coercition_bonus = coercition_bonus;
        this.mouvement = mouvement;
        this.mouvement_bonus = mouvement_bonus;
        this.perception = perception;
        this.perception_bonus = perception_bonus;
        this.persuasion = persuasion;
        this.persuasion_bonus = persuasion_bonus;
        this.volonté = volonté;
        this.volonté_bonus = volonté_bonus;
        this.dégats = dégats;
        this.bonus_dégatArme = bonus_dégatArme;
        this.typeDégat = typeDégat;
        this.armurePercant = armurePercant;
        this.armureContondant = armureContondant;
        this.armureTranchant = armureTranchant;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public int getChance_max() {
        return chance_max;
    }

    public void setChance_max(int chance_max) {
        this.chance_max = chance_max;
    }

    public int getÉclat() {
        return éclat;
    }

    public void setÉclat(int éclat) {
        this.éclat = éclat;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getForce_bonus() {
        return force_bonus;
    }

    public void setForce_bonus(int force_bonus) {
        this.force_bonus = force_bonus;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getEndurance_bonus() {
        return endurance_bonus;
    }

    public void setEndurance_bonus(int endurance_bonus) {
        this.endurance_bonus = endurance_bonus;
    }

    public int getAgilité() {
        return agilité;
    }

    public void setAgilité(int agilité) {
        this.agilité = agilité;
    }

    public int getAgilité_bonus() {
        return agilité_bonus;
    }

    public void setAgilité_bonus(int agilité_bonus) {
        this.agilité_bonus = agilité_bonus;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getIntelligence_bonus() {
        return intelligence_bonus;
    }

    public void setIntelligence_bonus(int intelligence_bonus) {
        this.intelligence_bonus = intelligence_bonus;
    }

    public int getTrempe() {
        return trempe;
    }

    public void setTrempe(int trempe) {
        this.trempe = trempe;
    }

    public int getTrempe_bonus() {
        return trempe_bonus;
    }

    public void setTrempe_bonus(int trempe_bonus) {
        this.trempe_bonus = trempe_bonus;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public int getSocial_bonus() {
        return social_bonus;
    }

    public void setSocial_bonus(int social_bonus) {
        this.social_bonus = social_bonus;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPv_max() {
        return pv_max;
    }

    public void setPv_max(int pv_max) {
        this.pv_max = pv_max;
    }

    public int getCoeffRegenPv() {
        return coeffRegenPv;
    }

    public void setCoeffRegenPv(int coeffRegenPv) {
        this.coeffRegenPv = coeffRegenPv;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getManaMax() {
        return manaMax;
    }

    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }

    public int getCoeffRegenMana() {
        return coeffRegenMana;
    }

    public void setCoeffRegenMana(int coeffRegenMana) {
        this.coeffRegenMana = coeffRegenMana;
    }

    public int getDégats_bonus() {
        return dégats_bonus;
    }

    public void setDégats_bonus(int dégats_bonus) {
        this.dégats_bonus = dégats_bonus;
    }

    public int getArmeDistance() {
        return armeDistance;
    }

    public void setArmeDistance(int armeDistance) {
        this.armeDistance = armeDistance;
    }

    public int getArmeDistance_bonus() {
        return armeDistance_bonus;
    }

    public void setArmeDistance_bonus(int armeDistance_bonus) {
        this.armeDistance_bonus = armeDistance_bonus;
    }

    public int getDiscretion() {
        return discretion;
    }

    public void setDiscretion(int discretion) {
        this.discretion = discretion;
    }

    public int getDiscretion_bonus() {
        return discretion_bonus;
    }

    public void setDiscretion_bonus(int discretion_bonus) {
        this.discretion_bonus = discretion_bonus;
    }

    public int getDressage() {
        return dressage;
    }

    public void setDressage(int dressage) {
        this.dressage = dressage;
    }

    public int getDressage_bonus() {
        return dressage_bonus;
    }

    public void setDressage_bonus(int dressage_bonus) {
        this.dressage_bonus = dressage_bonus;
    }

    public int getMélée() {
        return mélée;
    }

    public void setMélée(int mélée) {
        this.mélée = mélée;
    }

    public int getMélée_bonus() {
        return mélée_bonus;
    }

    public void setMélée_bonus(int mélée_bonus) {
        this.mélée_bonus = mélée_bonus;
    }

    public int getNage() {
        return nage;
    }

    public void setNage(int nage) {
        this.nage = nage;
    }

    public int getNage_bonus() {
        return nage_bonus;
    }

    public void setNage_bonus(int nage_bonus) {
        this.nage_bonus = nage_bonus;
    }

    public int getPremiersSoin() {
        return premiersSoin;
    }

    public void setPremiersSoin(int premiersSoin) {
        this.premiersSoin = premiersSoin;
    }

    public int getPremiersSoin_bonus() {
        return premiersSoin_bonus;
    }

    public void setPremiersSoin_bonus(int premiersSoin_bonus) {
        this.premiersSoin_bonus = premiersSoin_bonus;
    }

    public int getCoercition() {
        return coercition;
    }

    public void setCoercition(int coercition) {
        this.coercition = coercition;
    }

    public int getCoercition_bonus() {
        return coercition_bonus;
    }

    public void setCoercition_bonus(int coercition_bonus) {
        this.coercition_bonus = coercition_bonus;
    }

    public int getMouvement() {
        return mouvement;
    }

    public void setMouvement(int mouvement) {
        this.mouvement = mouvement;
    }

    public int getMouvement_bonus() {
        return mouvement_bonus;
    }

    public void setMouvement_bonus(int mouvement_bonus) {
        this.mouvement_bonus = mouvement_bonus;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getPerception_bonus() {
        return perception_bonus;
    }

    public void setPerception_bonus(int perception_bonus) {
        this.perception_bonus = perception_bonus;
    }

    public int getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(int persuasion) {
        this.persuasion = persuasion;
    }

    public int getPersuasion_bonus() {
        return persuasion_bonus;
    }

    public void setPersuasion_bonus(int persuasion_bonus) {
        this.persuasion_bonus = persuasion_bonus;
    }

    public int getVolonté() {
        return volonté;
    }

    public void setVolonté(int volonté) {
        this.volonté = volonté;
    }

    public int getVolonté_bonus() {
        return volonté_bonus;
    }

    public void setVolonté_bonus(int volonté_bonus) {
        this.volonté_bonus = volonté_bonus;
    }

    public int getDégats() {
        return dégats;
    }

    public void setDégats(int dégats) {
        this.dégats = dégats;
    }

    public int getBonus_dégatArme() {
        return bonus_dégatArme;
    }

    public void setBonus_dégatArme(int bonus_dégatArme) {
        this.bonus_dégatArme = bonus_dégatArme;
    }

    public String getTypeDégat() {
        return typeDégat;
    }

    public void setTypeDégat(String typeDégat) {
        this.typeDégat = typeDégat;
    }

    public int getArmurePercant() {
        return armurePercant;
    }

    public void setArmurePercant(int armurePercant) {
        this.armurePercant = armurePercant;
    }

    public int getArmureContondant() {
        return armureContondant;
    }

    public void setArmureContondant(int armureContondant) {
        this.armureContondant = armureContondant;
    }

    public int getArmureTranchant() {
        return armureTranchant;
    }

    public void setArmureTranchant(int armureTranchant) {
        this.armureTranchant = armureTranchant;
    }
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Modele.Combattant;
import Modele.Personnage;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thoma
 */
public class Database {
    
    private ArrayList<Personnage> m_database;

    public Database() throws IOException {
        this.readFromFile(new File("./data/database.json"));
    }

    public Database(ArrayList<Personnage> m_database) {
        this.m_database = m_database;
    }

    public ArrayList<Personnage> getM_database() {
        return m_database;
    }

    public void setM_database(ArrayList<Personnage> m_database) {
        this.m_database = m_database;
    }
    
    public void readFromFile(File _file) throws IOException{
        ObjectMapper objMap = new ObjectMapper();
        ArrayList<Personnage> db;
        db = objMap.readValue(_file, objMap.getTypeFactory().constructCollectionType(ArrayList.class, Personnage.class));
        //ArrayList<User> db = mapper.readValue(jsonInput, new TypeReference<List<ConsultantDto>>(){});
        System.out.println("Database lue avec : "+db.toString());
        this.m_database = db;
    }
    
    public void writeToFile(File _file, List<Combattant> _lCombattant){
        
    }

    public boolean findWithNom(String _nom) {
        boolean found = false;
//        for (User data : m_dataBase) {
//            if(data.getM_nom().equals(_nom)) {
//                found = true;
//            }
//        }
        for(int i=0;i<this.m_database.size();i++) {
//            System.out.println("class of this.m_dataBase.get(i) : "+this.m_dataBase.get(i).getClass()+" ; value : "+this.m_dataBase.get(i));
            Personnage data = this.m_database.get(i);

            if(data.getNom().equals(_nom)) {
                found = true;
            }
        }
        return found;
    }

    public String addToDatabasa(Personnage _personnage) {
        if(this.findWithNom(_personnage.getNom())) {
            return "user already exist";
        }
        this.m_database.add(_personnage);
        return "user created with sucess";
    }

    public Personnage getPersonnageByNom(String _nom) {
        for (Personnage data : this.m_database) {
            if(data.getNom().equals(_nom)) {
                return data;
            }
        }
        return new Personnage("null");
    }

    @Override
    public String toString() {
        return "Database{" + "m_database=" + m_database + '}';
    }
   
}

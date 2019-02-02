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
        ArrayList<Combattant> db;
        db = objMap.readValue(_file, objMap.getTypeFactory().constructCollectionType(ArrayList.class, Personnage.class));
        //ArrayList<User> db = mapper.readValue(jsonInput, new TypeReference<List<ConsultantDto>>(){});
        System.out.println("Database lue avec : "+db.toString());
        this.m_database = db;
    }
    
    public void writeToFile(File _file, List<Combattant> _lCombattant){
        
    }
    
    public boolean findWithMdp(String _mdp) {
        boolean found = false;
        for (User data : m_dataBase) {
            if(data.getM_mdp().equals(_mdp)) {
                found = true;
            }
        }
        return found;
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

            if(data.getNo.equals(_nom)) {
                found = true;
            }
        }
        return found;
    }

    public String addToDatabasa(User _user) {
        if(this.findWithNom(_user.getM_nom())) {
            return "user already exist";
        }
        this.m_dataBase.add(_user);
        return "user created with sucess";
    }

    public User getUserByNom(String _nom) {
        for (User data : this.m_dataBase) {
            if(data.getM_nom().equals(_nom)) {
                return data;
            }
        }
        return new User("null", "null");
    }

    public boolean userExist(String _login, String _mdp) {
        if(this.findWithNom(_login)) {
            Combattant uTemp = this.getUserByNom(_login);
            if(uTemp.getM_mdp().equals(_mdp)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Database{" + "m_database=" + m_database + '}';
    }
   
}

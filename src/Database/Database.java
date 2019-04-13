/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Modele.Message;
import Modele.Personnage;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author thoma
 */
public class Database {

    private ArrayList<Personnage> m_database;
    private Personnage personnageToAdd;
    private Message message;

    private String cheminDuFichier = "src/data/";
    private String datebaseFile = "database.json";
    private String messageFile = "message.json";

    public Database() {
        this.m_database = new ArrayList<>();
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

    public Personnage getPersonnageToAdd() {
        return personnageToAdd;
    }

    public void setPersonnageToAdd(Personnage personnageToAdd) {
        this.personnageToAdd = personnageToAdd;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public File getActualFile(String _nameOfFile) {
        return new File(cheminDuFichier+_nameOfFile);
    }

    public void readDbFromFile() throws IOException {
        ObjectMapper objMap = new ObjectMapper();
        ArrayList<Personnage> db = objMap.readValue(getActualFile(this.datebaseFile), objMap.getTypeFactory().constructCollectionType(ArrayList.class, Personnage.class));
        this.m_database = db;
//        String db = objMap.readValue(_file, String.class);
//        System.out.println("Database lue avec : " + db.toString());
    }

    public void readMessageFromFile() throws IOException {
        ObjectMapper objMap = new ObjectMapper();
        this.message = objMap.readValue(getActualFile(this.messageFile), Message.class);
//        System.out.println("Database lue avec : " + this.toString());
    }

    public void writeDbToFile() throws IOException {
        ObjectMapper objMap = new ObjectMapper();
        BufferedWriter writer = new BufferedWriter(new FileWriter(cheminDuFichier + this.datebaseFile));
        writer.write(objMap.writeValueAsString(this.m_database));

        writer.close();
        this.m_database.clear();
    }

    public void writeMessageToFile(String _nomFichier, Message _message) throws IOException {
        ObjectMapper objMap = new ObjectMapper();
        BufferedWriter writer = new BufferedWriter(new FileWriter(cheminDuFichier + _nomFichier));
        writer.write(objMap.writeValueAsString(_message));
        System.out.println("message on writeMessageToFile : "+_message.getMsg());

        writer.close();
        this.message = new Message();
    }

    public boolean findWithNom(String _nom) {
        boolean found = false;
//        for (User data : m_dataBase) {
//            if(data.getM_nom().equals(_nom)) {
//                found = true;
//            }
//        }
        for (int i = 0; i < this.m_database.size(); i++) {
//            System.out.println("class of this.m_dataBase.get(i) : "+this.m_dataBase.get(i).getClass()+" ; value : "+this.m_dataBase.get(i));
            Personnage data = this.m_database.get(i);

            if (data.getNom().equals(_nom)) {
                found = true;
            }
        }
        return found;
    }

    public String addToDatabase(Personnage _personnage) {
        if (this.findWithNom(_personnage.getNom())) {
            return "user already exist";
        }
        this.m_database.add(_personnage);
        return "user created with sucess";
    }

    public Personnage getPersonnageByNom(String _nom) {
        for (Personnage data : this.m_database) {
            if (data.getNom().equals(_nom)) {
                return data;
            }
        }
        return new Personnage("null");
    }

    @Override
    public String toString() {
        return "Database{" + "m_database=" + m_database + ", personnageToAdd=" + personnageToAdd + ", message=" + message + ", cheminDuFichier=" + cheminDuFichier + '}';
    }

}

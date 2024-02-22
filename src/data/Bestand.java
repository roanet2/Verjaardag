package data;

import model.Verjaardag;
import util.Fout;

import java.io.*;
import java.util.List;



public class Bestand {

    private String filenaam;

    public Bestand(String filenaam) {
        this.filenaam = filenaam;
    }

    public List<Verjaardag> leesTerug() throws Fout {
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(filenaam))){
            return(List<Verjaardag>) input.readObject();
        } catch( IOException | ClassNotFoundException ex){
            throw new Fout ("melding");
        }
    }

    public void schrijfWeg(List<Verjaardag> verjaardagen) throws Fout {
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filenaam))){
            output.writeObject(verjaardagen);
        }catch( IOException  ex){
            throw new Fout ("melding");
        }
    }
}


package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ContactList  {

    private ObservableList<contact> contacts ;

    public ContactList() {
        contacts = FXCollections.observableArrayList();
    }

    public ObservableList<contact> getContacts(){
        return contacts;
    }
    public void addContact(contact item){
        contacts.add(item);

    }

    public void addContactByUser(contact item){
        contacts.add(contacts.size()-1,item);
        this.sort();
    }

    public void deleteContact(contact item){
        contacts.remove(item);
    }

    public int sizeOfList(){
        return contacts.size();
    }

    public void sort(){
        Collections.sort(contacts);
    }



}

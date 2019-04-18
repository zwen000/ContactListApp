package main;

import data.ContactList;
import data.contact;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Controller {
    private ContactList theList = new ContactList();

    public TextField fnameTest = new TextField();
    public TextField lnameTest = new TextField();
    public TextField PhoneNum = new TextField();
    public TextField email = new TextField();

    public Button  saveButton = new Button();
    public Button deleteButton = new Button();

    @FXML
    private ListView<contact> contactListView = new ListView();

    public void initialize(){
        //contactListView.setItems(theList );
        contact c1 = new contact( "Mr." ,"One", "email@email.com", "12345678910" );
        contact c2 = new contact( "Mr." ,"Two", "email@email.com", "12345678910" );
        contact c3 = new contact( "Mr." ,"Three", "email@email.com", "12345678910" );
        contact c4 = new contact( "Mr." ,"Four", "email@email.com", "12345678910" );
        contact c5 = new contact( "Zhicong" ,"Wen", "zwen000@citymail.cuny.edu", "5670602" );
        contact last = new contact( "Select to create a new contact" ,"~", "", "" );

        theList.addContact(c1);
        theList.addContact(c2);
        theList.addContact(c3);
        theList.addContact(c4);
        theList.addContact(c5);
        theList.addContact(last);

        contactListView.getItems().setAll(theList.getContacts());
        contactListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        contactListView.getSelectionModel().selectFirst();
    }


    @FXML
    public void handleClickLickView(){
        if(contactListView.getSelectionModel().getSelectedIndex() == theList.sizeOfList()-1)
        {
            fnameTest.setText(" ");
            lnameTest.setText(" ");
            PhoneNum.setText(" ");
            email.setText(" ");
            return;
        }
       contact item =   contactListView.getSelectionModel().getSelectedItem();
        fnameTest.setText(item.getFirstName());
        lnameTest.setText(item.getLastName());
        PhoneNum.setText(item.getPhoneNumber());
        email.setText(item.getEmail());
    }




    @FXML
    public void saveButtonOnClick(){
        contact item =   contactListView.getSelectionModel().getSelectedItem();
        if (item == null) return;
        if( contactListView.getSelectionModel().getSelectedIndex()== theList.sizeOfList()-1)
        {
            String FN = fnameTest.getText();
            String LN = lnameTest.getText();
            String NUM = PhoneNum.getText();
            String EMAIL = email.getText();
            System.out.println(FN+LN+NUM+EMAIL);
            contact newContact = new contact(FN,LN,EMAIL,NUM);
            theList.addContactByUser(newContact);
            contactListView.getItems().setAll(theList.getContacts());
            return;
        }
        item.setFirstName(fnameTest.getText());
        item.setLastName(lnameTest.getText());
        item.setPhoneNumber(PhoneNum.getText());
        item.setEmail(email.getText());
        contactListView.getItems().setAll(theList.getContacts());
    }






    @FXML
    public void deleteButtonOnClick(){
        contact item =   contactListView.getSelectionModel().getSelectedItem();
        if( contactListView.getSelectionModel().getSelectedIndex()!= theList.sizeOfList()-1)
        {
            theList.deleteContact(item);
            contactListView.getItems().setAll(theList.getContacts());
            fnameTest.setText(" ");
            lnameTest.setText(" ");
            PhoneNum.setText(" ");
            email.setText(" ");
        }


    }

}

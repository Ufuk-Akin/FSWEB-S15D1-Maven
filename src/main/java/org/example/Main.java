package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Contact contact = new Contact("Ufuk" ,"12421414");

        MobilePhone mobilePhone = new MobilePhone("141424124" , new ArrayList<>());
        mobilePhone.addNewContact(new Contact("ufuk" ,"141432214"));
        mobilePhone.addNewContact(new Contact("ufuk" ,"41243"));
        mobilePhone.addNewContact(new Contact("aer" ,"41243"));
        mobilePhone.printContacts();
    }
}

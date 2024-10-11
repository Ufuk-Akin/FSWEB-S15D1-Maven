package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List <Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if(contact == null || contact.getName() == null || contact.getPhoneNumber() == null ) {
            return false;
        }
        if (findContact(contact.getName()) >= 0) {
           return false;
        }
        return myContacts.add(contact);
    }

    public boolean updateContact(Contact oldContact , Contact newContact) {
        int indexOfContact = findContact(oldContact);
        if (indexOfContact >= 0 ) {
            this.myContacts.set(indexOfContact, newContact);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeContact(Contact contact) {
        if (contact == null || findContact(contact) >= 0) {
            this.myContacts.remove(contact);
            return true;
        } else {
            return false;
        }
    }

    public int findContact(Contact contact) {
        if (this.myContacts.contains(contact)) {
            return this.myContacts.indexOf(contact);
        } else {
            return -1;
        }
    }

    public int findContact (String contactName) {
        for(int i = 0; i < this.myContacts.size(); i++) {
           // Contact contact = myContacts.get(i);
            if (this.myContacts.get(i).getName().equalsIgnoreCase(contactName)) {
                return i;
            }
        }
            return -1;
    }

    public Contact queryContact(String contactName) {
     int index = this.findContact(contactName);
     if (index >= 0) {
         return this.myContacts.get(index);
     }else {
         return null;
     }

    }

    public void printContacts() {
        // Contact List Yazdırır.
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i+1) +". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }


}

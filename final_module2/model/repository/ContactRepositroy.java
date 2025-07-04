package final_module2.model.repository;

import final_module2.model.entity.Contact;
import final_module2.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositroy implements IContactRepository {
    private final boolean APPEND = true;
    @Override
    public List<Contact> findAll() {
        List<Contact> contactList = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFromFile("final_module2/data/contact.csv");
        String[] array= null;
        for (String string : stringList) {
            if (string.trim().isEmpty()) {
                continue;
            }
            array = string.split(",");
            if (array.length >= 7) {
                Contact contact = new Contact(array[0].trim(),array[1].trim(),array[2].trim(),array[3].trim(),array[4].trim(),array[5].trim(),array[6].trim());
                contactList.add(contact);
            }
        }
        return contactList;
    }

    @Override
    public void addContact(Contact contact) {
        List<String> contactList = new ArrayList<>();
        contactList.add(contact.getInfoToCSV());
        ReadAndWriteFile.writeToFile("final_module2/data/contact.csv",contactList,APPEND);

    }

    @Override
    public void deleteContact(String number) {
        List<Contact> contactList = findAll();
        contactList.removeIf(contact1 -> contact1.getNumber().equals(number));
        saveAllContacts(contactList);
    }

    @Override
    public void updateContact(Contact contact) {
        List<Contact> contactList = findAll();
        for (int i=0;i<contactList.size();i++){
            if(contactList.get(i).getNumber().equals(contact.getNumber())){
                contactList.set(i,contact);
                break;
            }
        }
        saveAllContacts(contactList);

    }

    @Override
    public Contact findContactByNumber(String number) {
        List<Contact> contactList = findAll();
        for (Contact contact : contactList) {
            if(contact.getNumber().equals(number)){
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact findContactByName(String name) {
        List<Contact> contactList = findAll();
        for (Contact contact : contactList) {
            if (contact.getUserName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public boolean isExistContact(String number) {
        List<Contact> allContacts = findAll();
        for (Contact contact : allContacts) {
            if (contact.getNumber().equals(number)) {
                return true;
            }
        }
        return false;
    }

    private  void saveAllContacts( List<Contact> contactList){
        List<String> stringList = new ArrayList<>();
        for (Contact contact : contactList) {
            stringList.add(contact.getInfoToCSV());
        }
        ReadAndWriteFile.writeToFile("final_module2/data/contact.csv",stringList,false);
    }
}

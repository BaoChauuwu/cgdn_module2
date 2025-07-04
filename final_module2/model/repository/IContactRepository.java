package final_module2.model.repository;

import final_module2.model.entity.Contact;

import java.util.List;

public interface IContactRepository {
    List<Contact> findAll();
    void addContact(Contact contact);
    void deleteContact(String number);
    void updateContact(Contact contact);
    Contact findContactByNumber(String number);
    Contact findContactByName(String name);
    boolean isExistContact(String number);

}

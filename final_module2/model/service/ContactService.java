package final_module2.model.service;

import final_module2.model.entity.Contact;
import final_module2.model.repository.ContactRepositroy;
import final_module2.model.repository.IContactRepository;

import java.util.List;

public class ContactService implements IContactService{
    private IContactRepository contactRepository = new ContactRepositroy();
    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public void addContact(Contact contact) {
        if(contact != null && !isExistContact(contact.getNumber())){
            contactRepository.addContact(contact);
        }
        else {
            System.out.println("Contact da ton tai");
        }
    }

    @Override
    public void deleteContact(String number) {
        if (contactRepository.findContactByNumber(number) != null) {
            contactRepository.deleteContact(number);
        }
        else {
            System.out.println("Contact khong tim thay");
        }

    }

    @Override
    public void updateContact(Contact contact) {
        if (contact != null && isExistContact(contact.getNumber())) {
            contactRepository.updateContact(contact);
        }
        else  {
            System.out.println("Contact khong tim thay");
        }

    }

    @Override
    public Contact findContactByNumber(String number) {
        return contactRepository.findContactByNumber(number);
    }

    @Override
    public Contact findContactByName(String name) {
        return contactRepository.findContactByName(name);
    }

    @Override
    public boolean isExistContact(String number) {
        return contactRepository.isExistContact(number);
    }
}

package template;

import java.util.ArrayList;
import java.util.List; 
import java.util.Objects;

class Contact {
    private String name;
    private List<PhonebookEntry> phonebookEntries;

    public Contact(String name) {
        this.name = name;
        this.phonebookEntries = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Getter method for the list of phonebook entries
    public List<PhonebookEntry> getPhonebookEntries() {
        return phonebookEntries; 
    }

    // Method to add a phonebook entry for the contact
    public void addPhonebookEntry(String number, String type) {
        PhonebookEntry pbEntry = new PhonebookEntry(number, type);
        this.phonebookEntries.add(pbEntry);
    }

    // Overridden hashCode method to generate a hash code based on the contact name
    @Override
    public int hashCode() {
        return Objects.hash(name) % 2; 
    }

    // Overridden equals method to check equality based on contact name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact contact = (Contact) obj;
        return Objects.equals(name, contact.name);
    }

    // Overridden toString method for easy display of the contact details
    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number(s): " + phonebookEntries.toString();
    }
}

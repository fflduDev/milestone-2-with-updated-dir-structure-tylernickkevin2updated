package template;

import java.util.*;

public class PhonebookHandler implements iPhonebookHander {
    private Map<Contact, List<PhonebookEntry>> phonebook;

    public PhonebookHandler(Map<Contact, List<PhonebookEntry>> phonebook) {
        this.phonebook = phonebook;
    }

    // Bubble Sort Implementation
    @Override
    public List<Contact> sortByName() {
        List<Contact> contacts = new ArrayList<>(phonebook.keySet());

        int n = contacts.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (contacts.get(j).getName().compareTo(contacts.get(j + 1).getName()) > 0) {
                    Collections.swap(contacts, j, j + 1);
                }
            }
        }
        return contacts;
    }

    // Binary Search Implementation
    @Override
    public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name) {
        int left = 0, right = sortedContacts.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Contact midContact = sortedContacts.get(mid);

            int comparison = midContact.getName().compareTo(name);

            if (comparison == 0) {
                return midContact.getPhonebookEntries();
            } else if (comparison < 0) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        return Collections.emptyList();
    }

    // Display all contacts and their entries
    @Override
    public void display(List<Contact> sortedContacts) {
        for (Contact contact : sortedContacts) {
            System.out.println("Name: " + contact.getName());
            for (PhonebookEntry entry : contact.getPhonebookEntries()) {
                System.out.println("  " + entry.getType() + ": " + entry.getPhoneNumber());
            }
        }
    }
}

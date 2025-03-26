package template;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestHarness {

    private static Map<Contact, List<PhonebookEntry>> phonebook = new HashMap<>();
    private static Contact p1, p2, p3, p4, p5;
    private static PhonebookHandler phonebookHander;

    public static void main(String[] args) throws InterruptedException {
        init();

        // Display equality and inequality cases using overridden equals
        TEST_Equals(p1, p2); 
        TEST_Equals(p3, p3); 

        // Demonstrate hash collisions and non-collisions
        TEST_hashcode(p1, p3); 
        TEST_hashcode(p2, p3); 

        // Create the phonebook handler
        phonebookHander = new PhonebookHandler(phonebook);

        // Sorting contacts
        List<Contact> sortedContacts = TEST_Sort(phonebookHander);
        TEST_Display(sortedContacts);

        // Search test case
        TEST_Search(phonebookHander, sortedContacts, "Juan");
    }

    public static List<Contact> TEST_Sort(PhonebookHandler phonebookHandler) {
        System.out.println("\nSorted Phonebook (Bubble Sort):");
        return phonebookHandler.sortByName();
    }

    public static void TEST_Search(PhonebookHandler phonebookHandler, List<Contact> sortedContacts, String name) {
        System.out.println("\n-- Search results for " + name + " --");
        List<PhonebookEntry> selectedEntries = phonebookHandler.binarySearch(sortedContacts, name);
        for (PhonebookEntry entry : selectedEntries) {
            System.out.println("Entries for " + name + " " + entry.getType() + " " + entry.getPhoneNumber());
        }
    }

    public static void TEST_Display(List<Contact> sortedContacts) {
        phonebookHander.display(sortedContacts);
    }

    public static void TEST_Equals(Contact r1, Contact r2) {
        System.out.println("\nChecking r1.equals(r2) for:");
        System.out.println("Name: " + r1.getName() + ", Phone Number(s): " + r1.getPhonebookEntries());
        System.out.println("Name: " + r2.getName() + ", Phone Number(s): " + r2.getPhonebookEntries());
        System.out.println(r1.equals(r2));
    }

    public static void TEST_hashcode(Contact r1, Contact r2) {
        System.out.println("\nChecking r1.hashcode = r2.hashcode for:");
        System.out.println("Name: " + r1.getName() + ", Phone Number(s): " + r1.getPhonebookEntries());
        System.out.println("Name: " + r2.getName() + ", Phone Number(s): " + r2.getPhonebookEntries());
        if (r1.hashCode() == r2.hashCode()) {
            System.out.println("Hash matches - we're in the same bucket ( collision!): 1");
        } else {
            System.out.println("NO hash match: " + r1.hashCode() + " / " + r2.hashCode());
        }
    }

    public static void init() throws InterruptedException {
        System.out.println("Building Contacts ....");
        TimeUnit.SECONDS.sleep(1);

        p1 = new Contact("Jan");
        p2 = new Contact("Stan");
        p3 = new Contact("Juan");
        p4 = new Contact("Mun");
        p5 = new Contact("Ran");

        System.out.println("Building Phonebook Entries ....");
        TimeUnit.SECONDS.sleep(1);

        p1.addPhonebookEntry("2034032233", "Home");
        p1.addPhonebookEntry("5532233322", "Cell");
        p1.addPhonebookEntry("1120092829", "Work");

        p2.addPhonebookEntry("1034032233", "Home");
        p2.addPhonebookEntry("2532233322", "Cell");
        p2.addPhonebookEntry("3120092829", "Work");

        p3.addPhonebookEntry("4034032233", "Home");
        p3.addPhonebookEntry("5532233322", "Cell");
        p3.addPhonebookEntry("6120092829", "Work");

        p4.addPhonebookEntry("6034032233", "Home");
        p4.addPhonebookEntry("3532233322", "Cell");
        p4.addPhonebookEntry("1120092829", "Work");

        p5.addPhonebookEntry("0034032233", "Home");
        p5.addPhonebookEntry("0532233322", "Cell");
        p5.addPhonebookEntry("0120092829", "Work");

        System.out.println("Adding Entries to the phonebook ....\n");
        TimeUnit.SECONDS.sleep(1);

        phonebook.put(p1, p1.getPhonebookEntries());
        phonebook.put(p2, p2.getPhonebookEntries());
        phonebook.put(p3, p3.getPhonebookEntries());
        phonebook.put(p4, p4.getPhonebookEntries());
        phonebook.put(p5, p5.getPhonebookEntries());
    }
}

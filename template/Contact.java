package template;

/**
 * model a Contact 
 * Contact has a name & list of phonebook entries
 * 
 * Support adding phonebookEntry to a contact
 * 
 * @Override hashCode and equals
 * 
 */

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

    public List<PhonebookEntry> getPhonebookEntries() {
        return phonebookEntries;
    }

    public void addPhonebookEntry(String number, String type) {
        PhonebookEntry pbEntry = new PhonebookEntry(number, type);
        this.phonebookEntries.add(pbEntry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name) % 2;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact contact = (Contact) obj;
        return Objects.equals(name, contact.name);
    }
}

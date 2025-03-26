package template;

import java.util.Objects;

/**
 *   model a PhonebookEntry 
 *   
 *   PhonebookEntry has a phoneNumber and type
 */
class PhonebookEntry {
    private String phoneNumber;
    private String type;

    public PhonebookEntry(String phoneNumber, String type) {
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PhonebookEntry that = (PhonebookEntry) obj;
        return Objects.equals(phoneNumber, that.phoneNumber) &&
               Objects.equals(type, that.type);
    }

    @Override
    public String toString() {
        return phoneNumber + " " + type;
    }
}

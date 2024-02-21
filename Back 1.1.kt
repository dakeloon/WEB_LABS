//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val myPhone: MobilePhone = MobilePhone("+79521654131")

    val contact1 = Contact("Semen", "+79609332854")
    val contact2 = Contact("Lisiy", "+79999999999")

    //Добавить контакт
    myPhone.addNewContact(contact1)
    myPhone.printContacts()

    //Изменить контакт(из старого в новый)
    val isUpdate: Boolean = myPhone.updateContact(contact1, contact2)
    println("\nUpdate:$isUpdate")
    myPhone.printContacts()

    //Удалить контакт
    val isRemove: Boolean = myPhone.removeContact(contact2)
    println("\nRemove:$isRemove")
    myPhone.printContacts()
    myPhone.addNewContact(contact1)
    myPhone.addNewContact(contact2)
    val index: Int = myPhone.findContact(contact1)
    println("\nIndex:$index")
    myPhone.printContacts()

    //Поиск по имени
    val semenContact: Contact? = myPhone.queryContact("Me")
    println("\n${semenContact?.name} ${semenContact?.phoneNumber}")
}

data class Contact(
    var name: String = "",
    var phoneNumber: String = ""
)

class MobilePhone(phoneNumber: String) {

    val myPhone: String = phoneNumber
    var myContacts: MutableList<Contact> = mutableListOf()

    init {
        myContacts.add(Contact("Me", myPhone))
    }

    fun addNewContact(newContact: Contact) {
        myContacts.add(newContact)
    }

    fun updateContact(oldContact: Contact, newContact: Contact) : Boolean {
        for (i in 0..myContacts.size) {
            if (myContacts[i].name == oldContact.name &&
                myContacts[i].phoneNumber == oldContact.phoneNumber) {
                myContacts[i] = newContact
                return true
            }
        }

        return false;
    }

    fun removeContact(removeContact: Contact) : Boolean {
        for (contact in myContacts) {
            if (contact.name == removeContact.name &&
                contact.phoneNumber == removeContact.phoneNumber) {
                myContacts.remove(contact)
                return true;
            }
        }

        return false;
    }

    fun findContact(contact: Contact) : Int {
        for (i in 0..myContacts.size) {
            if (myContacts[i].name == contact.name &&
                myContacts[i].phoneNumber == contact.phoneNumber) {
                return i
            }
        }

        return -1
    }

    fun queryContact(name: String) : Contact? {
        for (i in 0..myContacts.size) {
            if (myContacts[i].name == name) {
                return myContacts[i]
            }
        }

        return null
    }

    fun printContacts() {
        for (contact in myContacts) {
            println("${contact.name}, ${contact.phoneNumber}")
        }
    }
}


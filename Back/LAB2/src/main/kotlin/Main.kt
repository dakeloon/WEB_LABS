package org.example


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
data class Contact(val name: String, val phoneNumber: String)

class MobilePhone(name: String, phone: String) {
    private val myContacts = mutableListOf<Contact>()

    init {
        addNewContact(Contact(name, phone))
    }

    fun addNewContact(newContact: Contact): Boolean {
        if (findContact(newContact) >= 0) {
            println("Контакт ${newContact.name} уже существует")
            return false
        }
        myContacts.add(newContact)
        println("Контакт ${newContact.name} добавлен")
        return true
    }

    fun updateContact(oldContact: Contact, newContact: Contact): Boolean {
        val position = findContact(oldContact)
        if (position < 0) {
            println("Контакт ${oldContact.name} не найден")
            return false
        }
        myContacts[position] = newContact
        println("Контакт ${oldContact.name} обновлен")
        return true
    }

    fun removeContact(contact: Contact): Boolean {
        val position = findContact(contact)
        if (position < 0) {
            println("Контакт ${contact.name} не найден")
            return false
        }
        myContacts.removeAt(position)
        println("Контакт ${contact.name} удален")
        return true
    }

    private fun findContact(contact: Contact): Int {
        return myContacts.indexOfFirst { it.name == contact.name && it.phoneNumber == contact.phoneNumber }
    }

    fun queryContact(name: String): Contact? {
        val position = myContacts.indexOfFirst { it.name == name }
        return if (position >= 0) myContacts[position] else null
    }

    fun printContacts() {
        println("Список контактов:")
        myContacts.forEach { println("${it.name} - ${it.phoneNumber}") }
    }
}

fun main() {
    val mobilePhone = MobilePhone("ya", "")

    mobilePhone.addNewContact(Contact("Семен", "123456789"))
    mobilePhone.addNewContact(Contact("Михаил", "987654321"))

    mobilePhone.printContacts()

    val updatedContact = Contact("Семен", "999999999")
    mobilePhone.updateContact(Contact("Семен", "123456789"), updatedContact)
    mobilePhone.printContacts()

    mobilePhone.removeContact(updatedContact)
    mobilePhone.printContacts()
}
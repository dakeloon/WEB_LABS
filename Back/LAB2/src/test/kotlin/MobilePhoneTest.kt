import org.example.Contact
import org.example.MobilePhone
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory


class MobilePhoneTest {

    private val phone: MobilePhone = MobilePhone("Ya", "65676")
    private val logger = LoggerFactory.getLogger(Contact::class.java)

    @Test
    fun addNewContact() {
        val newContact: Contact = Contact("SEREGA", "+79521654131")
        val isAdd: Boolean = phone.addNewContact(newContact)
        assertEquals(true, isAdd)
        //assertTrue(isAdd)
    }

    @Test
    fun removeContact() {
        val removeContact: Contact = Contact("Ya", "65676")
        val isRemove: Boolean = phone.removeContact(removeContact)
        assertEquals(true, isRemove)
        //assertTrue(isRemove)
        logger.info("Я")
    }
}
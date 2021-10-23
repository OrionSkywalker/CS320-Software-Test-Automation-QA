//Author: Ryan McFarland
//Date: 09/19/2021
//Class: SNHU CS320
package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ContactTest  {

	protected String contactID, firstNameT, lastNameT, numberT, addressT;
	protected String longContactID, longFirstName, longLastName, longNumber, longAddress, shortNumber;
	
	@BeforeEach
	void setUp() {
		contactID = "0123456789";
		firstNameT = "INITIAL";
		lastNameT = "INITIAL";
		numberT = "0123456789";
		addressT = "INITIAL";
		longContactID = "012345678901";
		longFirstName = "Supercalifragilistic";
		longLastName = "Expialidocious";
		longNumber = "5551111212333";
		longAddress = "1600 Pennsylvania Avenue Washington DC A Really Long Address";
		shortNumber = "5";		
	}
	
	//test creation of a contact with no arguments
	@Test
	void contactConstructorTest() {
		Contact contact = new Contact();
		assertAll("No Arguments Contstructor",
			()-> assertNotNull(contact.getContactID()),
            ()-> assertNotNull(contact.getFirstName()),
            ()-> assertNotNull(contact.getLastName()),              
            ()-> assertNotNull(contact.getNumber()),
            ()-> assertNotNull(contact.getAddress()));   				
	}
	
	//test creation of a contact with contactID
	@Test
	void contactIDConstructorTest() {
		Contact contact = new Contact(contactID);
		assertAll("Contact ID Constructor Test",
				() -> assertEquals(contactID, contact.getContactID()),
				()-> assertNotNull(contact.getFirstName()),
	            ()-> assertNotNull(contact.getLastName()),              
	            ()-> assertNotNull(contact.getNumber()),
	            ()-> assertNotNull(contact.getAddress())); 
	}
	
	//test creation of a contact with contactID and firstName provided
	@Test 
	void firstNameConstructorTest() {
		Contact contact = new Contact(contactID, firstNameT);
		assertAll("firstNameConstructorTest",
				() -> assertEquals(contactID, contact.getContactID()),
				()-> assertEquals(firstNameT, contact.getFirstName()),
	            ()-> assertNotNull(contact.getLastName()),              
	            ()-> assertNotNull(contact.getNumber()),
	            ()-> assertNotNull(contact.getAddress())); 
	}
	
	//test creation of a contact with contactID firstName and lastName provided
	@Test
	void lastNameConstructorTest() {
		Contact contact = new Contact(contactID, firstNameT, lastNameT);
		assertAll("lastNameConstructorTest",
				() -> assertEquals(contactID, contact.getContactID()),
				()-> assertEquals(firstNameT, contact.getFirstName()),
	            ()-> assertEquals(lastNameT, contact.getLastName()),              
	            ()-> assertNotNull(contact.getNumber()),
	            ()-> assertNotNull(contact.getAddress())); 
	}
	
	//test creation of a contact with contactID, firstName, lastName, and number provided
	@Test
	void numberConstructorTest() {
		Contact contact = new Contact(contactID, firstNameT, lastNameT, numberT);
		assertAll("numberConstructorTest",
				() -> assertEquals(contactID, contact.getContactID()),
				()-> assertEquals(firstNameT, contact.getFirstName()),
	            ()-> assertEquals(lastNameT, contact.getLastName()),              
	            ()-> assertEquals(numberT, contact.getNumber()),
	            ()-> assertNotNull(contact.getAddress()));
	}
	
	//test creation of a contact with all fields provided
	@Test
	void addressConstructorTest() {
		Contact contact = new Contact(contactID,firstNameT, lastNameT, numberT, addressT  );
		assertAll("addressConstructorTest", 
				() -> assertEquals(contactID, contact.getContactID()),
				()-> assertEquals(firstNameT, contact.getFirstName()),
	            ()-> assertEquals(lastNameT, contact.getLastName()),              
	            ()-> assertEquals(numberT, contact.getNumber()),
	            ()-> assertEquals(addressT, contact.getAddress()));
	}
	
	//test first name parameters, cant be null or more than 10 characters
	@Test
	void setFirstNameTest() {
		Contact contact = new Contact();
		contact.setFirstName(firstNameT);
		assertAll("firstNameTest",
			()-> assertEquals(firstNameT, contact.getFirstName()),
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setFirstName(null)),    
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setFirstName(longFirstName)));				
	}
	
	//test last name parameters, cant be null and cant be more than 10 characters
	@Test 
	void setLastNameTest() {
		Contact contact = new Contact();
		contact.setLastName(firstNameT);
		assertAll("lastNameTest",
			()-> assertEquals(lastNameT, contact.getFirstName()),
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setLastName(null)),    
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setLastName(longLastName)));
	}
	
	//test number, cant be null, more than 10 digits, less than 10 digits, have any values other than integers
	@Test
	void setNumberTest() {
		Contact contact = new Contact();
		contact.setNumber(numberT);
		assertAll("numberTest",
			()-> assertEquals(numberT, contact.getNumber()),
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setNumber("")),    
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setNumber(longNumber)),
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setNumber(shortNumber)),
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setNumber(contactID)));
	}
	
	@Test
	void setAddressTest() {
		Contact contact = new Contact();
		contact.setAddress(addressT);
		assertAll("addressTest",
				()-> assertEquals(addressT, contact.getAddress()),
		        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setAddress(null)),    
		        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setAddress(longAddress)));
	}
	
	@Test
	void setContactIDTest() {
		Contact contact = new Contact();
		contact.setContactID(contactID);
		assertAll("contactIDTest",
				()-> assertEquals(contactID, contact.getContactID()),
		        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setContactID(null)),    
		        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setContactID(longContactID)));
	}
}

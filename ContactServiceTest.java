//Author: Ryan McFarland
//Date: 09/19/2021
//Class: SNHU CS320
package main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ContactServiceTest {
	protected String contactID, firstNameT, lastNameT, numberT, addressT, longContactID, 
					 longFirstName, longLastName, longNumber, longAddress, shortNumber;
	
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
	
	@Test
	void newContactTest() {
		ContactService service = new ContactService();
		
		service.newContact();
		assertAll("service", 
				()-> assertNotNull(service.getContactList().get(0).getContactID()),	            
		        () -> assertEquals("INITIAL", service.getContactList().get(0).getFirstName()),
		        ()-> assertEquals("INITIAL", service.getContactList().get(0).getLastName()), 
		        ()-> assertEquals("0123456789",service.getContactList().get(0).getNumber()),                   
		        ()-> assertEquals("INITIAL", service.getContactList().get(0).getAddress()));
		
		service.newContact(firstNameT);
		assertAll("service", 
				()-> assertNotNull(service.getContactList().get(1).getContactID()),	            
		        () -> assertEquals(firstNameT, service.getContactList().get(1).getFirstName()),
		        ()-> assertEquals("INITIAL", service.getContactList().get(1).getLastName()), 
		        ()-> assertEquals("0123456789",service.getContactList().get(1).getNumber()),                   
		        ()-> assertEquals("INITIAL", service.getContactList().get(1).getAddress()));
		
		service.newContact(firstNameT, lastNameT);
		assertAll("service", 
				()-> assertNotNull(service.getContactList().get(2).getContactID()),	            
		        () -> assertEquals(firstNameT, service.getContactList().get(2).getFirstName()),
		        ()-> assertEquals(lastNameT, service.getContactList().get(2).getLastName()), 
		        ()-> assertEquals("0123456789",service.getContactList().get(2).getNumber()),                   
		        ()-> assertEquals("INITIAL", service.getContactList().get(2).getAddress()));
		
		service.newContact(firstNameT, lastNameT, numberT);
		assertAll("service", 
				()-> assertNotNull(service.getContactList().get(3).getContactID()),	            
		        () -> assertEquals(firstNameT, service.getContactList().get(3).getFirstName()),
		        ()-> assertEquals(lastNameT, service.getContactList().get(3).getLastName()), 
		        ()-> assertEquals(numberT,service.getContactList().get(3).getNumber()),                   
		        ()-> assertEquals("INITIAL", service.getContactList().get(3).getAddress()));
		
		service.newContact(firstNameT, lastNameT, numberT, addressT);
		assertAll("service", 
				()-> assertNotNull(service.getContactList().get(4).getContactID()),	            
		        () -> assertEquals(firstNameT, service.getContactList().get(4).getFirstName()),
		        ()-> assertEquals(lastNameT, service.getContactList().get(4).getLastName()), 
		        ()-> assertEquals(numberT,service.getContactList().get(4).getNumber()),                   
		        ()-> assertEquals(addressT, service.getContactList().get(4).getAddress()));
		
	}
	
	@Test
	void deleteContactTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertThrows(Exception.class, ()->service.deleteContact(contactID));
		assertAll(()->service.deleteContact(service.getContactList().get(0).getContactID()));
	}
	
	 @Test
	  void updateFirstNameTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.setFirstName(service.getContactList().get(0).getContactID(),
	                            firstNameT);
	    assertEquals(firstNameT, service.getContactList().get(0).getFirstName());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setFirstName(
	                         service.getContactList().get(0).getContactID(),
	                         longFirstName));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setFirstName(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.setFirstName(contactID, firstNameT));
	  }
	
	 @Test
	  void updateLastNameTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.setLastName(service.getContactList().get(0).getContactID(),
	                           lastNameT);
	    assertEquals(lastNameT, service.getContactList().get(0).getLastName());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setLastName(
	                         service.getContactList().get(0).getContactID(),
	                         longLastName));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setLastName(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.setLastName(contactID, lastNameT));
	  }

	  @Test
	  void updatePhoneNumberTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.setNumber(service.getContactList().get(0).getContactID(), numberT);
	                              
	    assertEquals(numberT,
	                 service.getContactList().get(0).getNumber());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setNumber(
	                         service.getContactList().get(0).getContactID(),
	                         longNumber));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setNumber(
	                         service.getContactList().get(0).getContactID(),
	                         shortNumber));
	    assertThrows(
	        IllegalArgumentException.class,
	        ()
	            -> service.setNumber(
	                service.getContactList().get(0).getContactID(), "5551212"));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setNumber(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.setNumber(contactID, lastNameT));
	  }

	  @Test
	  void updateAddressTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.setAddress(service.getContactList().get(0).getContactID(),
	                          addressT);
	    assertEquals(addressT, service.getContactList().get(0).getAddress());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setAddress(
	                         service.getContactList().get(0).getContactID(),
	                         longAddress));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setAddress(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.setAddress(contactID, addressT));
	  }

}

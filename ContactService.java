//Author: Ryan McFarland
//Date: 09/19/2021
//Class: SNHU CS320
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {
	
	
	private String uniqueContactID;
	
	private String newUniqueContactID() {
		 uniqueContactID = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
		 return uniqueContactID;			 
	}
	private List<Contact> contactList = new ArrayList<>();
	
	public void newContact() {
		Contact contact = new Contact(newUniqueContactID());
		contactList.add(contact);
	}
	
	public void newContact(String firstName) {
		Contact contact = new Contact(newUniqueContactID(), firstName);
		contactList.add(contact);
	}
	
	public void newContact(String firstName, String lastName) {
		Contact contact = new Contact (newUniqueContactID(), firstName, lastName);
		contactList.add(contact);
	}
	
	public void newContact(String firstName, String lastName, String number) {
		Contact contact = new Contact(newUniqueContactID(), firstName, lastName, number);
		contactList.add(contact);
	}
	
	public void newContact(String firstName, String lastName, String number, String address) {
		Contact contact = new Contact(newUniqueContactID(), firstName, lastName, number, address);
		contactList.add(contact);
	}
	
	public void deleteContact(String ID) throws Exception{
		contactList.remove(searchContacts(ID));
	}
	
	public void setFirstName(String ID, String firstName) throws Exception{
		searchContacts(ID).setFirstName(firstName);
	}
	
	public void setLastName(String ID, String lastName) throws Exception{
		searchContacts(ID).setLastName(lastName);
	}
	
	public void setAddress(String ID, String address) throws Exception{
		searchContacts(ID).setAddress(address);
	}
	
	public void setNumber(String ID, String number) throws Exception{
		searchContacts(ID).setNumber(number);
	}
	
	protected List<Contact> getContactList(){
		return contactList;
	}
	
	private Contact searchContacts(String ID) throws Exception{
		int i = 0;
		while(i< contactList.size()) {
			if(ID.equals(contactList.get(i).getContactID())) {
				return contactList.get(i);
			}
			i++;
		}
		throw new Exception("Not found.");
	}
}

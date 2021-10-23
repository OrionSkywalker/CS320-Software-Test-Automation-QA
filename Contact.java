//Author: Ryan McFarland
//Date: 09/19/2021
//Class: SNHU CS320
//Purpose: Class to create contacts

package main;

class Contact {
	
	//create the variables used in the contact class
	//If the class members declared as private then it may only be accessed by the class that defines the member.
	//If the class members declared as protected then it can be accessed only within the class itself and by inheriting and parent classes.
	
	private String contactID; //contactID shall be unique, shall not be null, not updatable
	private String firstName; //firstName cannot be longer than 10 characters, cant be null
	private String lastName; //lastName cannot be longer than 10 characters, cant be null
	private String number; //number must be exactly 10 digits, cant be null
	private String address; //address must be less than 30 characters, not null
	private static final String INITIAL_STRING = "INITIAL";
	private static final String INITIAL_INT = "0123456789";
	
	//constructor
	Contact(){
		this.contactID = INITIAL_INT;
		this.firstName = INITIAL_STRING;
		this.lastName = INITIAL_STRING;
		this.number = INITIAL_INT;
		this.address = INITIAL_STRING;
	}
	
	//Overloaded constructors with arguments setting value for each field progressively until last constructor accepts all fields
	
	Contact(String contactID){
		setContactID(contactID);
		this.firstName = INITIAL_STRING;
		this.lastName = INITIAL_STRING;
		this.number = INITIAL_INT;
		this.address = INITIAL_STRING;
	}
	
	Contact(String contactID, String firstName){
		setContactID(contactID);
		setFirstName(firstName);
		this.lastName = INITIAL_STRING;
		this.number = INITIAL_INT;
		this.address = INITIAL_STRING;
	}
	
	Contact(String contactID, String firstName, String lastName){
		setContactID(contactID);
		setFirstName(firstName);
		setLastName(lastName);
		this.number = INITIAL_INT;
		this.address = INITIAL_STRING;
	}
	
	Contact(String contactID, String firstName, String lastName, String number){
		setContactID(contactID);
		setFirstName(firstName);
		setLastName(lastName);
		setNumber(number);
		this.address = INITIAL_STRING;
	}
	
	Contact(String contactID,String firstName,String lastName, String number, String address){
		setFirstName(firstName);
		setLastName(lastName);
		setNumber(number);
		setAddress(address);
		setContactID(contactID);
	}
	
	//getters
	protected final String getContactID() {
		return contactID;
	}
	
	protected final String getFirstName() {
		return firstName;
	}
	
	protected final String getLastName() {
		return lastName;
	}
	
	protected final String getNumber() {
		return number;
	}
	
	protected final String getAddress() {
		return address;
	}
	
	//Setters that throw Exceptions for each of the attributes if they are assigned improperly
	
	//Note: If the class members declared as protected then it can be accessed only within the class itself
	//      and by inheriting and parent classes.
	
	protected void setFirstName(String firstName) {
		if(firstName == null) {
			throw new IllegalArgumentException("Field cannot be empty.");
		}
		else if (firstName.length()>10) {
			throw new IllegalArgumentException("Name must be less than 10 characters.");
		}
		else {
		this.firstName = firstName;
		}
	}
	
	protected void setLastName(String lastName) {
		if(lastName == null) {
			throw new IllegalArgumentException("Field cannot be empty.");
		}
		else if(lastName.length()>10) {
			throw new IllegalArgumentException("Name must be less than 10 characters.");
		}
		else {
			this.lastName = lastName;
		}
		
		
	}
	protected void setNumber(String number) {
		String regexTest = "[0-9]+"; //https://www.geeksforgeeks.org/how-to-check-if-string-contains-only-digits-in-java/
		if(number == null){
			throw new IllegalArgumentException("Number cannot be null.");
		}
		else if(!(number.length()==10)) {
			throw new IllegalArgumentException("Number must have a length of 10.");
		}
		else if(!(number.matches(regexTest))) {
			throw new IllegalArgumentException("Only numbers are allowed for phone numbers.");
		}
		else{
			this.number = number;
		}
	}
	
	public void setAddress(String address) {
		if(address == null){
			throw new IllegalArgumentException("Address field may not be empty.");
		}
		else if(address.length()>30) {
			throw new IllegalArgumentException("Address max length is 30.");
		}
		else {
			this.address = address;
		}
	}
	public void setContactID(String contactID) {
		if(contactID == null) {
			throw new IllegalArgumentException("ContactID cannot be null.");
		}
		else if (contactID.length()>10) {
			throw new IllegalArgumentException("ContactID must be shorter than 10 digits.");
		}
		
		else{
			this.contactID = contactID;
		}
	}
	
	
	
}

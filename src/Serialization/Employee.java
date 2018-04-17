package Serialization;

import java.io.Serializable;

class Employee implements Serializable{
	private transient Address address; // not an serializable object
	private Person person;
	
	Employee(Address address, Person person){
		this.address = address;
		this.person = person;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public String toString() {
		return "Employee [address=" + address + ", person=" + person +"]";
	}
}

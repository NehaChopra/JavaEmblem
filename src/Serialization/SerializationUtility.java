package Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class SerializationUtility {
	public static void main(String []args) {
		Person person = new Person(25, "Neha", "Chopra");
		Address address = new Address(1204, "Prateek Wisteria");
		Employee employee = new Employee(address, person);
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("/home/nehachopra/Desktop/employee.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(employee);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			FileInputStream fileInputStream = new FileInputStream("/home/nehachopra/Desktop/employee.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Employee recoveredObject = (Employee) objectInputStream.readObject();
			System.out.println(recoveredObject);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

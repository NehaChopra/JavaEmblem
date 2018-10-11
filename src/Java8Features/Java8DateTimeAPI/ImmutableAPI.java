package Java8Features.Java8DateTimeAPI;

/*
 * Points to be noted to make class immutable:
 * 1. Class must be declared as final (So that child classes can’t be created)
 * 2. Data members in the class must be declared as final (So that we can’t change the value of it after object creation)
 * 3. Data members in the class must be declared as private (So access to Data members is via getters)
 * 4. A parameterized constructor, deep copy constructor
 * 5. public Getter method for all the variables
 * 6. No setters(Avoid changing the value of the instance variable)
 * 
 * Benfits:
 * Thread safe, as once is object created value cannot be changed.
 * 
 */
public class ImmutableAPI {

	public static void main(String[] args) {
		ImmutableClaz obj = new ImmutableClaz("101","neha");
		System.out.println(obj);
		System.out.println(obj.hashCode());
	}
}
final class ImmutableClaz{
	/*
	 * final variable should be initialized there itself,
	 * no setters are provided in case of final variables
	 * construtor can be used to set the value of immutable class
	 */
	private final String id;
	private final String name;
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public ImmutableClaz(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String toString() {
		return "ImmutableClaz : [id] "+id + "\n[name] " +name;
	}
} 
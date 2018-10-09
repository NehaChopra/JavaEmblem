package Java10Features.LocalVariableTypeInference;

public class TypeInferenceExample {

	/*
	 * With Java 10, you can use var for local variables instead of a typed name (Manifest Type). 
	 * This is done by a new feature which is called Local Variable Type Inference.
	 * 
	 * Type inference is Java compiler’s ability to look at each method invocation and corresponding 
	 * declaration to determine the type argument (or arguments) that make the invocation applicable. 
	 * Type Inference is not to Java programming.For local variable declarations with initializer,
	 *  we can now use a reserved type name “var” instead of a manifest types.
	 * 
	 * 
	 * var list = new ArrayList<String>(); // infers ArrayList<String>
		var stream = list.stream();         // infers Stream<String>


		Manifest Type: Explicit identification of type for each variable being declared is called as Manifest Typing. 
		For example, If a variable “actors” is going to store a List of Actors, then its type List<Actor> is the manifest 
		type and its must be declared (as mentioned below) prior to Java 10:
		
		List<Actor> actors =  List.of(new Actor()); // Pre Java 10 
		var actors = List.of(new Actor()); // Java 10 onwards 


		How does Local Variable Type Inference work?
		Parsing a var statement, the compiler looks at the right hand side of the declaration, 
		and it infers the type from the right hand side (RHS) expression.
		
		Java is a dynamically typed language? Not really, it’s still a statically typed language.
		
		
		
		private static void readFile() throws IOException {
			var fileName = "Sample.txt";
			var line = "";
			var fileReader = new FileReader(fileName);
			var bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();
		}
		
		
		Now, let’s look at the decompiled code taken from IntelliJ IDEA decompiler.
		
		private static void readFile() throws IOException {
			String fileName = "Sample.txt";
			String line = "";
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();
		}
		
		
		Here the compiler properly infers the type of the variable from the right hand side expression and adds that to the bytecode.
		
		
		var is not a keyword, It’s a reserved type name
		We can create a variable named “var”.
		“var” as a method name is allowed.
		“var” as a package name is allowed.
		“var” cannot be used as the name of a class or interface.
		
		class var{ } // Compile Error
		LocalTypeInference.java:45: error: 'var' not allowed here
		class var{
		      ^
		  as of release 10, 'var' is a restricted local variable type and cannot be used for type declarations
		1 error
		
		interface var{ } // Compile Error


		Local Variable Type Inference Usage Scenarios
		Limited only to Local Variable with initializer
		Indexes of enhanced for loop or indexes
		Local declared in for loop
		
		
		Local Variable Type Inference Limitations
		Cannot use ‘var’ on variables without initializer
		Cannot be used for multiple variable definition
		Null cannot be used as an initializer for var, Null is not a type and hence the compiler cannot infer the type of the RHS expression.
		Cannot have extra array dimension brackets
		Poly expressions that have lambdas, method references, and array initializers, will trigger an error
		For the type inference of Lambda expressions, Method inference and the Array initializers, compiler relies on the left hand side expression or the argument definition of the method where the expression is passed while var uses RHS, this would form a cyclic inference and hence the compiler generates a compile time error.
		

		 var min = (a, b) -> a < b ? a : b;//// compile time error
		 var minimum = Math::min;
		 var nums = {1,2,3,4,5};
		 


		Generics with Local Variable Type Inference
		Java has type inference for Generics and to top of it, it also has to do Type Erasure for any generics statement. There are some edge cases which should be understood when using local type reference with Generics.
		
		Type Erasure: To implement generics, the Java compiler applies type erasure to, replace all type parameters in generic types with their bounds or Object if the type parameters are unbounded.
		
		var map1 = new HashMap(); // Inferred as HashMap
		var map2 = new HashMap<>(); // Inferred as HashMap<Object, Object>


		map1 – Compiler infers the map as HashMap without any generic type.

		map2 – The diamond operator relies on the LHS for the type inference, here the compiler cannot infer the LHS and hence it infers map2 to have upper bound or super type to which the HashMap can be denoted to. This leads to map2 being inferred as HashMap.

		
		
		Anonymous Class Types
		var runnable = new Runnable() {
			@Override
			public void run() {
				var numbers = List.of(5, 4, 3, 2, 1);
				for (var number : numbers) {
					System.out.println(number);
				}
			}
		};
		runThread(runnable);


		var map3 = new HashMap<>() { // anonymous class
			int someVar;
		};

		Here, when the diamond operator is used with anonymous class type, compiler cannot infer the RHS expression to any specific type. This leads to a formation of non-denotable Type.
		
		Firstly, compiler will get denotable type by using the super type for HashMap<>, which is HashMap<Object, Object>.
		
		Secondly, the anonymous class extension is applied. Finally this becomes a Non-denotable type which gets assigned to map3.


		A special case of Non Denotable type which was not possible to create earlier in Java, can now be created. Anonymously extending an Object class and adding attributes within it creates a POJO like class which can be assigned to a variable to hold context. This can be very useful in using a dynamically created object which can have structure within a temporary context
		
		var person = new Object() {
	class Name {
		String firstName;
		String lastName;
		public Name(String firstName, String lastName) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
	}
	Name name;
	Actor actor;
	public String displayName() {
		return name.getFirstName() + " " + name.lastName;
	}
	};
	person.name = person.new Name("Rakesh", "Kumar");
	System.out.println(person.displayName());
	
		
	 */
	
	public static void main(String[] args) {
		
	}
}

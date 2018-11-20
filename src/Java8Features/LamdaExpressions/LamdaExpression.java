package LamdaExpressions;

/*
 * The addition of lambda expressions adds syntax elements that increase the expressive power of Java
 * 
 * Lambda expressions take advantage of parallel process capabilities of multi-core environments as seen
 * with the support of pipeline operations on data in the Stream API.
 * 
 * 
 * They are anonymous methods (methods without names) used to implement a method defined by a functional interface.
 * 
 * Functional interface
 * A functional interface is an interface that contains one and only one abstract method.
 * 
 * 
 * If you take a look at the definition of the Java standard Runnable interface, you will notice how it falls into the
 * definition of functional interface because it only defines one method: run().
 * The left side specifies the parameters required by the expression, which could also be empty if no parameters are required.
 * 
 * The right side is the lambda body which specifies the actions of the lambda expression
 * 
 * lambda expression are more like a method references. Now method can be referenced.
 */




class NumericOperationsTest{
	public static void main(String []args) {
		/*
		 * definition of lamda expressions
		 */
		NumericOperations squareRoot = (num) -> (num * num)  ;
		NumericOperations modulus = (num) -> (num % 2);
		
		System.out.println(squareRoot.computation(3));

		System.out.println(modulus.computation(100));
	}
}

class GreetingMessageTest{
	public static void main(String []args) {
		/*
		 * make a reference to GreetingMessage interface and define different greeting expressions.
		 */
		GreetingMessage morningMessage = (String str) -> ( "Good Morning " + str + "!" )  ;
		GreetingMessage eveningMessage = (String str) -> ( "Good Evening " + str + "!" );
		
		System.out.println(morningMessage.dispayGreeting("NEHA CHOPRA"));

		System.out.println(eveningMessage.dispayGreeting("NEHA CHOPRA"));
	}
}

/*
 * Block Lambda Expressions
 */


class GreetingMessageTestBlock{
	public static void main(String []args) {
		/*
		 * make a reference to GreetingMessage interface and define different greeting expressions.
		 */
		GreetingMessage morningMessage = (String str) -> { 
																			return "Good Morning " + str + "!" ;
																		}  ;
																		
		GreetingMessage eveningMessage = (String str) -> {
																			return "Good Evening " + str + "!" ;
																		}	;
		
		System.out.println(morningMessage.dispayGreeting("NEHA CHOPRA"));

		System.out.println(eveningMessage.dispayGreeting("NEHA CHOPRA"));
	}
}

/*
 * Generic Functional Interfaces
 */

class GenericTest{
	public static void main(String []args) {
		
		Generic<Integer>  squareRoot = (num) -> (num * num)  ;
		Generic<Integer>  modulus = (num) -> (num % 2);
		
		System.out.println(squareRoot.computation(3));

		System.out.println(modulus.computation(100));
		
		
		Generic<String>  morningMessage = (String str) -> { 
																			return "Good Morning " + str + "!" ;
																		}  ;
																		
		Generic<String> eveningMessage = (String str) -> {
																			return "Good Evening " + str + "!" ;
																		}	;
		
		System.out.println(morningMessage.computation("NEHA CHOPRA"));

		System.out.println(eveningMessage.computation("NEHA CHOPRA"));
	}
}


/*
 * Lambda Expressions as arguments
 * To pass lambda expressions as parameters, just make sure the functional interface type is compatible with the required parameter.
 * 
 */



class LamdaExpression {
	public static void main(String []args) {
		
		Generic<String>  morningMessage = (String str) -> { 
																			return "Good Morning " + str + "!" ;
																		}  ;
																		
		Generic<String> eveningMessage = (String str) -> {
																			return "Good Evening " + str + "!" ;
																		}	;
		
		LamdaReferenceMethod(morningMessage, "NEHA CHOPRA");	
		LamdaReferenceMethod(eveningMessage, "NEHA CHOPRA");	
	}
	
	public static void LamdaReferenceMethod(Generic<String> generic, String str) {
		System.out.println(generic.computation(str));

		System.out.println(generic.computation(str));
	}
}

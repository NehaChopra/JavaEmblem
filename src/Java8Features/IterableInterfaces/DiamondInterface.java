package Java8Features.IterableInterfaces;

interface A{
	public void methodA();
	
	default void method() {
		System.out.println("default ------ methodA");
	}
}
interface B{
	public void methodB();
	
	default void method() {
		System.out.println("default ------ methodB");
	}
}

public class DiamondInterface implements A, B{

	public static void main(String[] args) {
		DiamondInterface obj = new DiamondInterface();
		obj.method();
	}

	@Override
	public void methodB() {
		System.out.println("methodB ------ DiamondInterface");
	}

	@Override
	public void methodA() {
		System.out.println("methodA ------ DiamondInterface");
	}

	/*
	 * Need to override the default method else it leads to compilation error
	 *  Java 8 uses default and static methods heavily in Collection API and 
	 *  default methods are added so that our code remains backward compatible.
	 */
	@Override
	public void method() {
		A.super.method();
		B.super.method();
	}
}

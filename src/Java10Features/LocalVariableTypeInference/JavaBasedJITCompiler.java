package Java10Features.LocalVariableTypeInference;

public class JavaBasedJITCompiler {
	public static void main(String[] args) {
	}
}

/*
 * 
 * https://chrisseaton.com/truffleruby/jokerconf17/
 * 
 * 
 * Graal was introduced in Java 9. It’s an alternative to the JIT compiler which we have been used to. 
 * It’s a plugin to the JVM, which means that the JIT compiler is not tied to JVM and it can be dynamically 
 * plugged in and replaced with any another plugin which JVMCI compliant (Java-Level JVM Compiler Interface).
 * It also brings Ahead of Time (AOT) compilation in java world. It also supports polyglot language interpretation
 * 
 * “A Java based Just in Time Compiler written in Java to convert the java bytecode to machine code.” 
 * Is it confusing? If JVM is written in Java, then don’t you need a JVM to run the JVM? The JVM can 
 * be compiled AOT and then JIT compiler can be used within JVM it for enhancing performance through live code optimization.
 * 
 * Graal is a complete rewrite of the JIT compiler in Java from scratch. Previous JIT complier was written in c++
 * 
 * 
 * 
 * 
 * 
 */

package Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)

public @interface MethodInfo {
	String author() default "Neha Chopra";
	String date();
	int revision() default 1;
}


/*
 * Java Annotation is metadata about the program embedded in the program itself. It can be parsed by the 
 * annotation parsing tool or by compiler. We can also specify annotation availability to either 
 * compile time only or till runtime also.
 * 
 * 
 * Before java annotations, program metadata was available through 
 * java comments or by javadoc but annotation offers more than that. Annotations metadata can 
 * be available at runtime too and annotation parsers can use it to determine the process flow.
 * 
 * Annotation methods can’t have parameters.
 * Annotation methods return types are limited to primitives, String, Enums, Annotation or array of these
 * Java Annotation methods can have default values.
 * Annotations can have meta annotations attached to them. Meta annotations are used to provide information about the annotation
 * 
 * 
 * 
 * 
 * import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Retention - Specifies how the marked annotation is stored—Whether in code only, compiled into the class, or available at run-time through reflection.

@Documented - Marks another annotation for inclusion in the documentation.

@Target - Marks another annotation to restrict what kind of java elements the annotation may be applied to

@Inherited - Marks another annotation to be inherited to subclasses of annotated class (by default annotations are not inherited to subclasses).
 */

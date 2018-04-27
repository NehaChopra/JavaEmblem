package Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
/*
 *  Reflection to parse java annotations from a class. 
 *  Please note that Annotation Retention Policy should be RUNTIME
 *   otherwise it’s information will not be available at runtime and 
 *   we wont be able to fetch any data from it.
 */
public @interface IssueInfo {
	Type type() default Type.BUG;
	
	String reporter() default "Chopra";
	
	String created() default "01/01/2018";
	
	Severity serverity() default Severity.S1;
}

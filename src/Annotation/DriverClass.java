package Annotation;

public class DriverClass {
	public static void main(String []args) {
		Class<TestAnnotate> obj = TestAnnotate.class;
		if(obj.isAnnotationPresent(IssueInfo.class)) {
			System.out.println(obj.getAnnotation(IssueInfo.class));
		}
	}
}

package HashcodeEqualsContract.ViolatingequalSymmetryWithInheritance;

public class Manager extends Employee {

	private String management;

	public Manager(int employeeId, String employeeName, String management) {
		super(employeeId, employeeName);
		this.management = management;
	}

	public String getManagement() {
		return management;
	}

	public void setManagement(String management) {
		this.management = management;
	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + ((management == null) ? 0 : management.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
//		if (!super.equals(obj))
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
		Manager other = (Manager) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;

		
		if (management == null) {
			if (other.management != null)
				return false;
		} else if (!management.equals(other.management))
			return false;
		return true;
	}

	public static void main(String[] args) {
		Employee e1 = new Employee(101, "Neha");
		Employee e2 = new Employee(101, "Neha");
		Manager e3 = new Manager(101, "Neha", "Manager");
		Manager e4 = new Manager(101, "Neha", "Manager");

//		System.out.println("Employee e1 :" + e1 + "\nEmployee e2 : " + e2 + "\nE1==E2 : " + (e1 == e2));
//		System.out.println("Employee e1 :" + e1 + "\nEmployee e2 : " + e2 + "\nE1 equals E2 : " + (e1.equals(e2)));
//		System.out.println();
//		System.out.println("Employee e3 :" + e3 + "\nEmployee e4 : " + e4 + "\nE3==E4 : " + (e3 == e4));
//		System.out.println("Employee e3 :" + e4 + "\nEmployee e4 : " + e4 + "\nE1 equals E4 : " + (e3.equals(e4)));
//		System.out.println();
		System.out.println("Employee e1 :" + e1 + "\nEmployee e3 : " + e3 + "\nE1==E3 : " + (e1 == e3));
		System.out.println("Employee e1 :" + e1 + "\nEmployee e3 : " + e3 + "\nE1 equals E3 : " + (e1.equals(e3)));
//		System.out.println();
//		System.out.println("Employee e4 :" + e4 + "\nEmployee e2 : " + e2 + "\nE4==E2 : " + (e4 == e2));
//		System.out.println("Employee e4 :" + e4 + "\nEmployee e2 : " + e2 + "\nE4 equals E2 : " + (e4.equals(e2)));
		/*
		 * The default implementation of equals() in the class Object says that equality
		 * is the same as object identity. And income and expenses are two distinct
		 * instances.
		 */
	}
}

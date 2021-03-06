package HashcodeEqualsContract;

public class Employee {

	private Integer employeeId;
	private String employeeName;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Employee(int employeeId, String employeeName) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
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
		return true;
	}

	public static void main(String[] args) {
		Employee e1 = new Employee(101, "Neha");
		Employee e2 = new Employee(101, "Neha");

		System.out.println("Employee e1 :" + e1 + "\nEmployee e2 : " + e2 + "\nE1==E2 : " + (e1 == e2));
		System.out.println("Employee e1 :" + e1 + "\nEmployee e2 : " + e2 + "\nE1 equals E2 : " + (e1.equals(e2)));
		/*
		 * The default implementation of equals() in the class Object says that equality
		 * is the same as object identity. And income and expenses are two distinct
		 * instances.
		 */
	}
}

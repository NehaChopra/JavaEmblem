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
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Employee)) {
			return false;
		}
		if(obj == this) {
			return true;
		}
		if((((Employee)obj).employeeId).equals(this.employeeId) && (((Employee)obj).employeeName).equals(this.employeeName)) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Employee e1 = new Employee(101,"Neha");
		Employee e2 = new Employee(101,"Neha");
		
		
		
		System.out.println("Employee e1 :"+e1+ "\nEmployee e2 : "+e2 + "\nE1==E2 : "+(e1==e2));
		System.out.println("Employee e1 :"+e1+ "\nEmployee e2 : "+e2 + "\nE1 equals E2 : "+(e1.equals(e2)));
	}
}

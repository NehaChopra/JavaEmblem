package Serialization;

class Address {
	private int flatNumber;
	private String society;
	
	Address(int flatNumber, String society){
		this.flatNumber = flatNumber;
		this.society = society;
	}
	public int getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}
	public String getSociety() {
		return society;
	}
	public void setSociety(String society) {
		this.society = society;
	}
	
	@Override
	public String toString() {
		return "Address [flatNumber=" + flatNumber + ", society=" + society + "]";
	}
}

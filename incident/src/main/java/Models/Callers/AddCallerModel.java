package Models.Callers;

public class AddCallerModel {
	private Integer iSQN;
	private String fName;
	private String lName;
	private String mobileNumber;
	private String relationToPatient;
	
	public Integer getiSQN() {
		return iSQN;
	}
	public void setiSQN(Integer iSQN) {
		this.iSQN = iSQN;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getRelationToPatient() {
		return relationToPatient;
	}
	public void setRelationToPatient(String relationToPatient) {
		this.relationToPatient = relationToPatient;
	}

}

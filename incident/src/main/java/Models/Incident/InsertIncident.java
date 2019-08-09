package Models.Incident;

public class InsertIncident {
	private int incidentType;
	private int incidentPriority;
	private int incidentLocationID;
	private String callerFName;
	private String callerLName;
	private String callerMobile;
	private String relationToPatient;
	
	
	public int getIncidentType() {
		return incidentType;
	}
	public void setIncidentType(int incidentType) {
		this.incidentType = incidentType;
	}
	public int getIncidentPriority() {
		return incidentPriority;
	}
	public void setIncidentPriority(int incidentPriority) {
		this.incidentPriority = incidentPriority;
	}
	public int getIncidentLocationID() {
		return incidentLocationID;
	}
	public void setIncidentLocationID(int incidentLocationID) {
		this.incidentLocationID = incidentLocationID;
	}
	public String getCallerMobile() {
		return callerMobile;
	}
	public void setCallerMobile(String callerMobile) {
		this.callerMobile = callerMobile;
	}
	public String getCallerLName() {
		return callerLName;
	}
	public void setCallerLName(String callerLName) {
		this.callerLName = callerLName;
	}
	public String getCallerFName() {
		return callerFName;
	}
	public void setCallerFName(String callerFName) {
		this.callerFName = callerFName;
	}
	public String getRelationToPatient() {
		return relationToPatient;
	}
	public void setRelationToPatient(String relationToPatient) {
		this.relationToPatient = relationToPatient;
	}

}

package Models.Incident;

public class InsertIncident {
	private int incidentType;
	private int incidentPriority;
	private int incidentLocationID;
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

}

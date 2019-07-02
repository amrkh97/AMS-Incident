package Models.Priority;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PrioritiesData {
	private String prioname;
	private String prionote;

		public String getPrioname() {
		return prioname;
	}
	public void setPrioname(String proname) {
		this.prioname = proname;
	}
	public String getPrionote() {
		return prionote;
	}
	public void setPrionote(String pronote) {
		this.prionote = pronote;
	}
	
	
}
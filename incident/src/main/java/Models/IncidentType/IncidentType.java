package Models.IncidentType;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IncidentType
{
	private String typeName;
	private String typeNote;
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeNote() {
		return typeNote;
	}
	public void setTypeNote(String typeNote) {
		this.typeNote = typeNote;
	}
	
	
}

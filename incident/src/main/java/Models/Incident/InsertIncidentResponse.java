package Models.Incident;

public class InsertIncidentResponse {
	private int iSN;
	private String hexReturn;
	private String responseMsg;
	public int getiSN() {
		return iSN;
	}
	public void setiSN(int iSN) {
		this.iSN = iSN;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	public String getHexReturn() {
		return hexReturn;
	}
	public void setHexReturn(String hexReturn) {
		this.hexReturn = hexReturn;
	}
}

package Models.Incident;

public enum ErrorMessages {
	
	NOPRIORITY,
	NOTYPE,
	NOLOCATIONID;
	
	private String Msg;

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}
	

}

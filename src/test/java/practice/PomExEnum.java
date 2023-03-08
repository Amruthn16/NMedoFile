package practice;


public enum PomExEnum {
FIRSTNAME("firstname"), 
LASTNAME("lastname"), 
TELEPHONE("telephone"),
EMAIL("email"),
PASSWORD("password"), 
CONFIRMPASSSWORD("confirm");

	
	String textData;
	
	private PomExEnum(String textData) {
		this.textData=textData;
}
	public String getTextData(){
		return textData;
		
	}
}

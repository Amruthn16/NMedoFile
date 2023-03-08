package practice;

import java.util.Base64;

public class EncryptAndDecrypt {

	public static void main(String[] args) {
		String encrytData ="YWRtaW4=";
		byte[] byteA = encrytData.getBytes();
		byte[] byteB = Base64.getDecoder().decode(byteA);
		String s= new String(byteB);
		System.out.println(s);
	}

}

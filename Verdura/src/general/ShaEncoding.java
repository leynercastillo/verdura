package general;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaEncoding {

    private String password;

    public ShaEncoding(String password) {
	super();
	this.password = password;
    }

    public String encodingPassword() throws NoSuchAlgorithmException {
	MessageDigest md = MessageDigest.getInstance("SHA-256");
	md.update(password.getBytes());
	byte passByte[] = md.digest();
	StringBuffer stringBuffer = new StringBuffer();
	for (int i = 0; i < passByte.length; i++) {
	    stringBuffer.append(Integer.toString((passByte[i] & 0xff) + 0x100, 16).substring(1));
	}
	return stringBuffer.toString();
    }
}

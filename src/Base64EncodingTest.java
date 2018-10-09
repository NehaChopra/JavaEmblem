import java.io.UnsupportedEncodingException;
import java.util.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64EncodingTest {
	private final static BASE64Encoder base64Encoder = new BASE64Encoder();
	private final static BASE64Decoder base64Decoder = new BASE64Decoder();
	
	private final static Base64.Encoder base64E = Base64.getEncoder();
	private final static Base64.Decoder base64D = Base64.getDecoder();
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String baseValue = "Base64EncodingTest";
		String encryptedValueSun = base64Encoder.encode(baseValue.getBytes());
		
		String encryptedValueUtil = base64E.encodeToString(baseValue.getBytes());
		byte[] decryptByte = base64D.decode(encryptedValueSun);

		System.out.println("sun.misc.BASE64Encoder = <" + encryptedValueSun + ">");
		System.out.println("java.util.Base64 = <" + encryptedValueSun + ">");
		System.out.println("sun.misc.BASE64Encoder -> Base64.Decoder = < " + new String(decryptByte, "UTF-8") + " >");
		
		System.out.println(encryptedValueSun.equals(encryptedValueUtil));
	}
}

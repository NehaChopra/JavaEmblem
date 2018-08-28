package StringUtils;

public class RandomStringGenerator {
	
	public static final String ALPHA_NUM = "!@#&_%[]{}().abcdefghijklmnopqrstuvwxyz9876543210ZYXWVUTSRQPONMLKJIHGFEDCBA";
	/**
	 * Method is responsible to generate random string based on given length.
	 * 
	 * @param length - length of the String.
	 * @return the string
	 */
	
	public static String generateRandomString(int length) {
		StringBuffer randomString = new StringBuffer(length);
		for(int index=0; index< length; index++) {
			randomString.append(ALPHA_NUM.charAt((int) (Math.random() * ALPHA_NUM.length())));
		}
		return randomString.toString();
	}
}


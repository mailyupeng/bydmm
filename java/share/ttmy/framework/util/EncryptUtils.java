package ttmy.framework.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class EncryptUtils {

	private static BASE64Encoder encoder = new BASE64Encoder();

	public static String md5Encoder(String s) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(s.getBytes("utf-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return encoder.encode(digest.digest());
	}
	
	public static void main(String[] args) {
		System.out.println(md5Encoder("admin"+"asdf123!@#"));
	}

}

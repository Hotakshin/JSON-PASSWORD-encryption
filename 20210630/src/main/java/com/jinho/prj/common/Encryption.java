package com.jinho.prj.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
	final char[] hexArray = "!@eargaernigearo$#23".toCharArray(); // 암호화 키
	
	/**
	 * SHA-256으로 해싱하는 메소드
	 * 
	 * @param bytes
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	private byte[] sha256(String msg) throws NoSuchAlgorithmException {
	    MessageDigest md = MessageDigest.getInstance("SHA-256");
	    md.update(msg.getBytes());
	    return md.digest();
	}
	
	/**
	 * 바이트를 헥사값으로 변환한다, type 1
	 * 
	 * @param bytes
	 * @return
	 */
	private String bytesToHex1(byte[] bytes) {
	    StringBuilder builder = new StringBuilder();
	    for (byte b: bytes) {
	      builder.append(String.format("%02x", b));
	    }
	    return builder.toString();
	}
	
	/**
	 * 바이트를 헥사값으로 변환한다, type 2
	 * 
	 * @param bytes
	 * @return
	 */
	private String bytesToHex2(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	// 암호키 없이 암호화
	public String typeOne (String str) throws NoSuchAlgorithmException {
		return bytesToHex1(sha256(str));
	}
	
	// 암호키를 사용하여 암호화
	public String typeTwo(String str) throws NoSuchAlgorithmException {
		return bytesToHex2(sha256(str));
	}
}

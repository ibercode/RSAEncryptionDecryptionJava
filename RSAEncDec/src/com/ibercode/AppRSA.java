package com.ibercode;

import java.math.BigInteger;
import java.util.stream.Stream;

public class AppRSA {

	public static void main(String[] args) {

		BigInteger publicKey = KeysGenerator.getPublicKey();
		BigInteger privateKey = KeysGenerator.getPrivateKey();
		BigInteger exponent = KeysGenerator.getExponent();
		
		String plain = "ibercode";

		System.out.println("PLAIN TEXT -> " + plain);
		String cipherText = getCipher(plain, exponent, publicKey);

		System.out.println("ENCRYPTED ->" + cipherText.toString());

		String plainText = getPlainText(cipherText, privateKey, publicKey);
		System.out.println("DECRYPTED -> " + plainText);

	}

	private static String getCipher(String plain, BigInteger exponent, BigInteger publicKey) {

		StringBuilder cipherText = new StringBuilder();

		plain.chars().forEach(c -> {
			BigInteger cipher = RSAUtils.getEncrypted(String.valueOf(c), exponent, publicKey);
			cipherText.append(cipher);
			cipherText.append(" ");
		});

		return cipherText.toString();
	}

	private static String getPlainText(String cipherText, BigInteger privateKey, BigInteger publicKey) {

		StringBuilder plainText = new StringBuilder();

		Stream.of(cipherText.split(" ")).forEach(c -> {
			BigInteger decrypted = RSAUtils.getDecrypted((BigInteger.valueOf(Long.parseLong(c))), privateKey,publicKey);
			String string = Character.toString((char) decrypted.intValue());
			plainText.append(string);
		});

		return plainText.toString();
	}
}
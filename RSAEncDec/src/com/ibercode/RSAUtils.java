package com.ibercode;

import java.math.BigInteger;

public class RSAUtils {

	public static BigInteger getEncrypted(String encoded, BigInteger exponent, BigInteger publicKey) {

		return BigInteger.valueOf(Long.parseLong(encoded)).modPow(exponent, publicKey);
	}

	public static BigInteger getDecrypted(BigInteger cipher, BigInteger privateKey, BigInteger publicKey) {

		return cipher.modPow(privateKey, publicKey);
	}

}

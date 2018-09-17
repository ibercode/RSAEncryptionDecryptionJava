package com.ibercode;

import java.math.BigInteger;
import java.security.SecureRandom;

public class KeysGenerator {
	
	private final static SecureRandom random = new SecureRandom();
	private final static BigInteger one = new BigInteger("1");
	
	private static BigInteger p =  BigInteger.probablePrime(23, random);
	private static BigInteger q = BigInteger.probablePrime(17, random);
	
	private static BigInteger publicKey = p .multiply(q);
	private static BigInteger exponent = BigInteger.valueOf(65537);
	private static BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
	
	private static BigInteger privateKey = exponent.modInverse(phi);
	
	public static BigInteger getPrivateKey() {
		return privateKey;
	}
	public static BigInteger getPublicKey() {
		return publicKey;
	}
	
	public static BigInteger getExponent() {
		return exponent;
	}
}

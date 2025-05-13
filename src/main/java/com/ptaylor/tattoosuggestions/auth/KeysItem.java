package com.ptaylor.tattoosuggestions.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a key item used for verifying Cognito tokens.
 */
public class KeysItem {

	/** The key type (e.g., RSA). */
	@JsonProperty("kty")
	private String kty;

	/** The exponent part of the key. */
	@JsonProperty("e")
	private String E;

	/** The intended use of the key (e.g., signing). */
	@JsonProperty("use")
	private String use;

	/** The key ID used to identify the key. */
	@JsonProperty("kid")
	private String kid;

	/** The algorithm used with the key (e.g., RS256). */
	@JsonProperty("alg")
	private String alg;

	/** The modulus part of the key. */
	@JsonProperty("n")
	private String N;

	/**
	 * Gets the key type.
	 * @return the key type
	 */
	public String getKty() {
		return kty;
	}

	/**
	 * Gets the exponent.
	 * @return the exponent
	 */
	public String getE() {
		return E;
	}

	/**
	 * Gets the intended use of the key.
	 * @return the use of the key
	 */
	public String getUse() {
		return use;
	}

	/**
	 * Gets the key ID.
	 * @return the key ID
	 */
	public String getKid() {
		return kid;
	}

	/**
	 * Gets the algorithm.
	 * @return the algorithm
	 */
	public String getAlg() {
		return alg;
	}

	/**
	 * Gets the modulus.
	 * @return the modulus
	 */
	public String getN() {
		return N;
	}
}

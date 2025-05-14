package com.ptaylor.tattoosuggestions.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the header part of a Cognito JWT token.
 */
public class CognitoTokenHeader {

	/** Key ID used to verify the token. */
	@JsonProperty("kid")
	private String kid;

	/** Algorithm used to sign the token. */
	@JsonProperty("alg")
	private String alg;

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
}

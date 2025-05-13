package com.ptaylor.tattoosuggestions.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the response containing tokens from Cognito authentication.
 */
public class TokenResponse {

	/** The access token used for authentication. */
	@JsonProperty("access_token")
	private String accessToken;

	/** The refresh token used to obtain a new access token. */
	@JsonProperty("refresh_token")
	private String refreshToken;

	/** The ID token used to authenticate the user. */
	@JsonProperty("id_token")
	private String idToken;

	/** The type of the token (e.g., Bearer). */
	@JsonProperty("token_type")
	private String tokenType;

	/** The duration in seconds until the access token expires. */
	@JsonProperty("expires_in")
	private int expiresIn;

	/**
	 * Gets the access token.
	 * @return the access token
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * Gets the refresh token.
	 * @return the refresh token
	 */
	public String getRefreshToken() {
		return refreshToken;
	}

	/**
	 * Gets the ID token.
	 * @return the ID token
	 */
	public String getIdToken() {
		return idToken;
	}

	/**
	 * Gets the token type.
	 * @return the token type
	 */
	public String getTokenType() {
		return tokenType;
	}

	/**
	 * Gets the expiration time of the access token in seconds.
	 * @return the expiration time
	 */
	public int getExpiresIn() {
		return expiresIn;
	}
}

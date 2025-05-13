package com.ptaylor.tattoosuggestions.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents the list of keys used for verifying Cognito tokens.
 */
public class Keys {

	/** A list of keys used to verify the token. */
	@JsonProperty("keys")
	private List<KeysItem> keys;

	/**
	 * Gets the list of keys.
	 * @return the list of keys
	 */
	public List<KeysItem> getKeys() {
		return keys;
	}
}

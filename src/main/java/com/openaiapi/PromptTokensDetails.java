package com.openaiapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the details of the prompt tokens in a request.
 */
public class PromptTokensDetails {

	@JsonProperty("audio_tokens")
	private int audioTokens;

	@JsonProperty("cached_tokens")
	private int cachedTokens;

	/**
	 * Sets the number of audio tokens.
	 *
	 * @param audioTokens the number of audio tokens
	 */
	public void setAudioTokens(int audioTokens) {
		this.audioTokens = audioTokens;
	}

	/**
	 * Gets the number of audio tokens.
	 *
	 * @return the number of audio tokens
	 */
	public int getAudioTokens() {
		return audioTokens;
	}

	/**
	 * Sets the number of cached tokens.
	 *
	 * @param cachedTokens the number of cached tokens
	 */
	public void setCachedTokens(int cachedTokens) {
		this.cachedTokens = cachedTokens;
	}

	/**
	 * Gets the number of cached tokens.
	 *
	 * @return the number of cached tokens
	 */
	public int getCachedTokens() {
		return cachedTokens;
	}

	/**
	 * Returns a string representation of the PromptTokensDetails object.
	 *
	 * @return a string representation of the object
	 */
	@Override
	public String toString() {
		return "PromptTokensDetails{" +
				"audio_tokens = '" + audioTokens + '\'' +
				",cached_tokens = '" + cachedTokens + '\'' +
				"}";
	}
}

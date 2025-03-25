package com.openaiapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents details about token usage in a completion response.
 */
public class CompletionTokensDetails {

	@JsonProperty("accepted_prediction_tokens")
	private int acceptedPredictionTokens;

	@JsonProperty("audio_tokens")
	private int audioTokens;

	@JsonProperty("reasoning_tokens")
	private int reasoningTokens;

	@JsonProperty("rejected_prediction_tokens")
	private int rejectedPredictionTokens;

	/**
	 * Sets the number of accepted prediction tokens.
	 *
	 * @param acceptedPredictionTokens the count of accepted prediction tokens
	 */
	public void setAcceptedPredictionTokens(int acceptedPredictionTokens) {
		this.acceptedPredictionTokens = acceptedPredictionTokens;
	}

	/**
	 * Gets the number of accepted prediction tokens.
	 *
	 * @return the count of accepted prediction tokens
	 */
	public int getAcceptedPredictionTokens() {
		return acceptedPredictionTokens;
	}

	/**
	 * Sets the number of audio tokens used in processing.
	 *
	 * @param audioTokens the count of audio tokens
	 */
	public void setAudioTokens(int audioTokens) {
		this.audioTokens = audioTokens;
	}

	/**
	 * Gets the number of audio tokens used in processing.
	 *
	 * @return the count of audio tokens
	 */
	public int getAudioTokens() {
		return audioTokens;
	}

	/**
	 * Sets the number of reasoning tokens used in the response.
	 *
	 * @param reasoningTokens the count of reasoning tokens
	 */
	public void setReasoningTokens(int reasoningTokens) {
		this.reasoningTokens = reasoningTokens;
	}

	/**
	 * Gets the number of reasoning tokens used in the response.
	 *
	 * @return the count of reasoning tokens
	 */
	public int getReasoningTokens() {
		return reasoningTokens;
	}

	/**
	 * Sets the number of rejected prediction tokens.
	 *
	 * @param rejectedPredictionTokens the count of rejected prediction tokens
	 */
	public void setRejectedPredictionTokens(int rejectedPredictionTokens) {
		this.rejectedPredictionTokens = rejectedPredictionTokens;
	}

	/**
	 * Gets the number of rejected prediction tokens.
	 *
	 * @return the count of rejected prediction tokens
	 */
	public int getRejectedPredictionTokens() {
		return rejectedPredictionTokens;
	}

	/**
	 * Returns a string representation of this object.
	 *
	 * @return a string representation of the CompletionTokensDetails object
	 */
	@Override
	public String toString() {
		return "CompletionTokensDetails{" +
				"accepted_prediction_tokens='" + acceptedPredictionTokens + '\'' +
				", audio_tokens='" + audioTokens + '\'' +
				", reasoning_tokens='" + reasoningTokens + '\'' +
				", rejected_prediction_tokens='" + rejectedPredictionTokens + '\'' +
				'}';
	}
}

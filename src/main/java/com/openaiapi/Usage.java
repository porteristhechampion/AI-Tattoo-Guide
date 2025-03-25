package com.openaiapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the usage details of tokens for a request.
 */
public class Usage {

	@JsonProperty("completion_tokens")
	private int completionTokens;

	@JsonProperty("prompt_tokens")
	private int promptTokens;

	@JsonProperty("completion_tokens_details")
	private CompletionTokensDetails completionTokensDetails;

	@JsonProperty("prompt_tokens_details")
	private PromptTokensDetails promptTokensDetails;

	@JsonProperty("total_tokens")
	private int totalTokens;

	/**
	 * Sets the number of completion tokens.
	 *
	 * @param completionTokens the number of completion tokens
	 */
	public void setCompletionTokens(int completionTokens) {
		this.completionTokens = completionTokens;
	}

	/**
	 * Gets the number of completion tokens.
	 *
	 * @return the number of completion tokens
	 */
	public int getCompletionTokens() {
		return completionTokens;
	}

	/**
	 * Sets the number of prompt tokens.
	 *
	 * @param promptTokens the number of prompt tokens
	 */
	public void setPromptTokens(int promptTokens) {
		this.promptTokens = promptTokens;
	}

	/**
	 * Gets the number of prompt tokens.
	 *
	 * @return the number of prompt tokens
	 */
	public int getPromptTokens() {
		return promptTokens;
	}

	/**
	 * Sets the completion tokens details.
	 *
	 * @param completionTokensDetails the completion tokens details
	 */
	public void setCompletionTokensDetails(CompletionTokensDetails completionTokensDetails) {
		this.completionTokensDetails = completionTokensDetails;
	}

	/**
	 * Gets the completion tokens details.
	 *
	 * @return the completion tokens details
	 */
	public CompletionTokensDetails getCompletionTokensDetails() {
		return completionTokensDetails;
	}

	/**
	 * Sets the prompt tokens details.
	 *
	 * @param promptTokensDetails the prompt tokens details
	 */
	public void setPromptTokensDetails(PromptTokensDetails promptTokensDetails) {
		this.promptTokensDetails = promptTokensDetails;
	}

	/**
	 * Gets the prompt tokens details.
	 *
	 * @return the prompt tokens details
	 */
	public PromptTokensDetails getPromptTokensDetails() {
		return promptTokensDetails;
	}

	/**
	 * Sets the total number of tokens.
	 *
	 * @param totalTokens the total number of tokens
	 */
	public void setTotalTokens(int totalTokens) {
		this.totalTokens = totalTokens;
	}

	/**
	 * Gets the total number of tokens.
	 *
	 * @return the total number of tokens
	 */
	public int getTotalTokens() {
		return totalTokens;
	}

	/**
	 * Returns a string representation of the Usage object.
	 *
	 * @return a string representation of the object
	 */
	@Override
	public String toString() {
		return "Usage{" +
				"completion_tokens = '" + completionTokens + '\'' +
				",prompt_tokens = '" + promptTokens + '\'' +
				",completion_tokens_details = '" + completionTokensDetails + '\'' +
				",prompt_tokens_details = '" + promptTokensDetails + '\'' +
				",total_tokens = '" + totalTokens + '\'' +
				"}";
	}
}

package com.openaiapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an individual choice item in an API response.
 */
public class ChoicesItem {

	@JsonProperty("finish_reason")
	private String finishReason;

	@JsonProperty("index")
	private int index;

	@JsonProperty("message")
	private Message message;

	@JsonProperty("logprobs")
	private Object logprobs;

	/**
	 * Sets the reason why the response generation finished.
	 *
	 * @param finishReason the reason for finishing
	 */
	public void setFinishReason(String finishReason) {
		this.finishReason = finishReason;
	}

	/**
	 * Gets the reason why the response generation finished.
	 *
	 * @return the finish reason
	 */
	public String getFinishReason() {
		return finishReason;
	}

	/**
	 * Sets the index of this choice item in the response list.
	 *
	 * @param index the index of the choice
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Gets the index of this choice item in the response list.
	 *
	 * @return the index of the choice
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Sets the message associated with this choice item.
	 *
	 * @param message the message object
	 */
	public void setMessage(Message message) {
		this.message = message;
	}

	/**
	 * Gets the message associated with this choice item.
	 *
	 * @return the message object
	 */
	public Message getMessage() {
		return message;
	}

	/**
	 * Sets the log probability information for this choice item.
	 *
	 * @param logprobs the log probability data
	 */
	public void setLogprobs(Object logprobs) {
		this.logprobs = logprobs;
	}

	/**
	 * Gets the log probability information for this choice item.
	 *
	 * @return the log probability data
	 */
	public Object getLogprobs() {
		return logprobs;
	}

	/**
	 * Returns a string representation of this object.
	 *
	 * @return a string representation of the ChoicesItem object
	 */
	@Override
	public String toString() {
		return "ChoicesItem{" +
				"finish_reason='" + finishReason + '\'' +
				", index='" + index + '\'' +
				", message='" + message + '\'' +
				", logprobs='" + logprobs + '\'' +
				'}';
	}
}

package com.openaiapi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a message in an API response, including its role, content, and additional metadata.
 */
public class Message {

	@JsonProperty("role")
	private String role;

	@JsonProperty("refusal")
	private Object refusal;

	@JsonProperty("annotations")
	private List<Object> annotations;

	@JsonProperty("content")
	private String content;

	/**
	 * Sets the role of the message (e.g., user, assistant, system).
	 *
	 * @param role the role associated with the message
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Gets the role of the message.
	 *
	 * @return the role associated with the message
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the refusal object, indicating if the message contains a refusal response.
	 *
	 * @param refusal the refusal data
	 */
	public void setRefusal(Object refusal) {
		this.refusal = refusal;
	}

	/**
	 * Gets the refusal object.
	 *
	 * @return the refusal data
	 */
	public Object getRefusal() {
		return refusal;
	}

	/**
	 * Sets the annotations associated with this message.
	 *
	 * @param annotations a list of annotation objects
	 */
	public void setAnnotations(List<Object> annotations) {
		this.annotations = annotations;
	}

	/**
	 * Gets the annotations associated with this message.
	 *
	 * @return a list of annotation objects
	 */
	public List<Object> getAnnotations() {
		return annotations;
	}

	/**
	 * Sets the textual content of the message.
	 *
	 * @param content the message content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the textual content of the message.
	 *
	 * @return the message content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Returns a string representation of this object.
	 *
	 * @return a string representation of the Message object
	 */
	@Override
	public String toString() {
		return "Message{" +
				"role='" + role + '\'' +
				", refusal='" + refusal + '\'' +
				", annotations='" + annotations + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}

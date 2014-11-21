package dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MessageboardId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class MessageboardId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer authorId;

	// Constructors

	/** default constructor */
	public MessageboardId() {
	}

	/** full constructor */
	public MessageboardId(Integer id, Integer authorId) {
		this.id = id;
		this.authorId = authorId;
	}

	// Property accessors

	@Column(name = "id", nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Author_id", nullable = false)
	public Integer getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MessageboardId))
			return false;
		MessageboardId castOther = (MessageboardId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getAuthorId() == castOther.getAuthorId()) || (this
						.getAuthorId() != null
						&& castOther.getAuthorId() != null && this
						.getAuthorId().equals(castOther.getAuthorId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getAuthorId() == null ? 0 : this.getAuthorId().hashCode());
		return result;
	}

}
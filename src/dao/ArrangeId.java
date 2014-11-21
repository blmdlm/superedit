package dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ArrangeId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ArrangeId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer authorId;
	private Integer staffId;

	// Constructors

	/** default constructor */
	public ArrangeId() {
	}

	/** full constructor */
	public ArrangeId(Integer id, Integer authorId, Integer staffId) {
		this.id = id;
		this.authorId = authorId;
		this.staffId = staffId;
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

	@Column(name = "Staff_id", nullable = false)
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ArrangeId))
			return false;
		ArrangeId castOther = (ArrangeId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getAuthorId() == castOther.getAuthorId()) || (this
						.getAuthorId() != null
						&& castOther.getAuthorId() != null && this
						.getAuthorId().equals(castOther.getAuthorId())))
				&& ((this.getStaffId() == castOther.getStaffId()) || (this
						.getStaffId() != null && castOther.getStaffId() != null && this
						.getStaffId().equals(castOther.getStaffId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getAuthorId() == null ? 0 : this.getAuthorId().hashCode());
		result = 37 * result
				+ (getStaffId() == null ? 0 : this.getStaffId().hashCode());
		return result;
	}

}
package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ScriptId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ScriptId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer authorId;
	private Integer magazineId;

	// Constructors

	/** default constructor */
	public ScriptId() {
	}

	/** full constructor */
	public ScriptId(Integer id, Integer authorId, Integer magazineId) {
		this.id = id;
		this.authorId = authorId;
		this.magazineId = magazineId;
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

	@Column(name = "Magazine_id", nullable = false)
	public Integer getMagazineId() {
		return this.magazineId;
	}

	public void setMagazineId(Integer magazineId) {
		this.magazineId = magazineId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ScriptId))
			return false;
		ScriptId castOther = (ScriptId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getAuthorId() == castOther.getAuthorId()) || (this
						.getAuthorId() != null
						&& castOther.getAuthorId() != null && this
						.getAuthorId().equals(castOther.getAuthorId())))
				&& ((this.getMagazineId() == castOther.getMagazineId()) || (this
						.getMagazineId() != null
						&& castOther.getMagazineId() != null && this
						.getMagazineId().equals(castOther.getMagazineId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getAuthorId() == null ? 0 : this.getAuthorId().hashCode());
		result = 37
				* result
				+ (getMagazineId() == null ? 0 : this.getMagazineId()
						.hashCode());
		return result;
	}

}
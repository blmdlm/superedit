package dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ComposeId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ComposeId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer staffId;
	private Integer scriptId;
	private Integer scriptAuthorId;
	private Integer scriptMagazineId;

	// Constructors

	/** default constructor */
	public ComposeId() {
	}

	/** full constructor */
	public ComposeId(Integer id, Integer staffId, Integer scriptId,
			Integer scriptAuthorId, Integer scriptMagazineId) {
		this.id = id;
		this.staffId = staffId;
		this.scriptId = scriptId;
		this.scriptAuthorId = scriptAuthorId;
		this.scriptMagazineId = scriptMagazineId;
	}

	// Property accessors

	@Column(name = "id", nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Staff_id", nullable = false)
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Column(name = "Script_id", nullable = false)
	public Integer getScriptId() {
		return this.scriptId;
	}

	public void setScriptId(Integer scriptId) {
		this.scriptId = scriptId;
	}

	@Column(name = "Script_Author_id", nullable = false)
	public Integer getScriptAuthorId() {
		return this.scriptAuthorId;
	}

	public void setScriptAuthorId(Integer scriptAuthorId) {
		this.scriptAuthorId = scriptAuthorId;
	}

	@Column(name = "Script_Magazine_id", nullable = false)
	public Integer getScriptMagazineId() {
		return this.scriptMagazineId;
	}

	public void setScriptMagazineId(Integer scriptMagazineId) {
		this.scriptMagazineId = scriptMagazineId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ComposeId))
			return false;
		ComposeId castOther = (ComposeId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getStaffId() == castOther.getStaffId()) || (this
						.getStaffId() != null && castOther.getStaffId() != null && this
						.getStaffId().equals(castOther.getStaffId())))
				&& ((this.getScriptId() == castOther.getScriptId()) || (this
						.getScriptId() != null
						&& castOther.getScriptId() != null && this
						.getScriptId().equals(castOther.getScriptId())))
				&& ((this.getScriptAuthorId() == castOther.getScriptAuthorId()) || (this
						.getScriptAuthorId() != null
						&& castOther.getScriptAuthorId() != null && this
						.getScriptAuthorId().equals(
								castOther.getScriptAuthorId())))
				&& ((this.getScriptMagazineId() == castOther
						.getScriptMagazineId()) || (this.getScriptMagazineId() != null
						&& castOther.getScriptMagazineId() != null && this
						.getScriptMagazineId().equals(
								castOther.getScriptMagazineId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getStaffId() == null ? 0 : this.getStaffId().hashCode());
		result = 37 * result
				+ (getScriptId() == null ? 0 : this.getScriptId().hashCode());
		result = 37
				* result
				+ (getScriptAuthorId() == null ? 0 : this.getScriptAuthorId()
						.hashCode());
		result = 37
				* result
				+ (getScriptMagazineId() == null ? 0 : this
						.getScriptMagazineId().hashCode());
		return result;
	}

}
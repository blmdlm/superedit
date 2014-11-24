package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Audit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "audit", catalog = "mydb")
public class Audit implements java.io.Serializable {

	// Fields

	private Integer id;
	private Script script;
	private Integer staffId;
	private String auditPath;
	private Date auditDate;
	private Integer auditRank;
	private Integer auditState;

	// Constructors

	/** default constructor */
	public Audit() {
	}

	/** minimal constructor */
	public Audit(Script script) {
		this.script = script;
	}

	/** full constructor */
	public Audit(Script script, Integer staffId, String auditPath,
			Date auditDate, Integer auditRank, Integer auditState) {
		this.script = script;
		this.staffId = staffId;
		this.auditPath = auditPath;
		this.auditDate = auditDate;
		this.auditRank = auditRank;
		this.auditState = auditState;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Script_id", nullable = false)
	public Script getScript() {
		return this.script;
	}

	public void setScript(Script script) {
		this.script = script;
	}

	@Column(name = "Staff_id")
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Column(name = "audit_path")
	public String getAuditPath() {
		return this.auditPath;
	}

	public void setAuditPath(String auditPath) {
		this.auditPath = auditPath;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "audit_date", length = 10)
	public Date getAuditDate() {
		return this.auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	@Column(name = "audit_rank")
	public Integer getAuditRank() {
		return this.auditRank;
	}

	public void setAuditRank(Integer auditRank) {
		this.auditRank = auditRank;
	}

	@Column(name = "audit_state")
	public Integer getAuditState() {
		return this.auditState;
	}

	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}

}
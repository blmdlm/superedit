package model;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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

	private AuditId id;
	private Staff staff;
	private Script script;
	private String auditAddr;
	private Date auditDate;
	private Integer auditRank;
	private Integer auditState;

	// Constructors

	/** default constructor */
	public Audit() {
	}

	/** minimal constructor */
	public Audit(AuditId id, Staff staff, Script script) {
		this.id = id;
		this.staff = staff;
		this.script = script;
	}

	/** full constructor */
	public Audit(AuditId id, Staff staff, Script script, String auditAddr,
			Date auditDate, Integer auditRank, Integer auditState) {
		this.id = id;
		this.staff = staff;
		this.script = script;
		this.auditAddr = auditAddr;
		this.auditDate = auditDate;
		this.auditRank = auditRank;
		this.auditState = auditState;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "staffId", column = @Column(name = "Staff_id", nullable = false)),
			@AttributeOverride(name = "scriptId", column = @Column(name = "Script_id", nullable = false)),
			@AttributeOverride(name = "scriptAuthorId", column = @Column(name = "Script_Author_id", nullable = false)),
			@AttributeOverride(name = "scriptMagazineId", column = @Column(name = "Script_Magazine_id", nullable = false)) })
	public AuditId getId() {
		return this.id;
	}

	public void setId(AuditId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Staff_id", nullable = false, insertable = false, updatable = false)
	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "Script_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "Script_Author_id", referencedColumnName = "Author_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "Script_Magazine_id", referencedColumnName = "Magazine_id", nullable = false, insertable = false, updatable = false) })
	public Script getScript() {
		return this.script;
	}

	public void setScript(Script script) {
		this.script = script;
	}

	@Column(name = "audit_addr")
	public String getAuditAddr() {
		return this.auditAddr;
	}

	public void setAuditAddr(String auditAddr) {
		this.auditAddr = auditAddr;
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
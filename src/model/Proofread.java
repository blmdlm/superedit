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
 * Proofread entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "proofread", catalog = "mydb")
public class Proofread implements java.io.Serializable {

	// Fields

	private ProofreadId id;
	private Staff staff;
	private Script script;
	private String proofAddr;
	private Date proofDate;
	private Integer proofRank;
	private String proofState;

	// Constructors

	/** default constructor */
	public Proofread() {
	}

	/** minimal constructor */
	public Proofread(ProofreadId id, Staff staff, Script script) {
		this.id = id;
		this.staff = staff;
		this.script = script;
	}

	/** full constructor */
	public Proofread(ProofreadId id, Staff staff, Script script,
			String proofAddr, Date proofDate, Integer proofRank,
			String proofState) {
		this.id = id;
		this.staff = staff;
		this.script = script;
		this.proofAddr = proofAddr;
		this.proofDate = proofDate;
		this.proofRank = proofRank;
		this.proofState = proofState;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "staffId", column = @Column(name = "Staff_id", nullable = false)),
			@AttributeOverride(name = "scriptId", column = @Column(name = "Script_id", nullable = false)),
			@AttributeOverride(name = "scriptAuthorId", column = @Column(name = "Script_Author_id", nullable = false)),
			@AttributeOverride(name = "scriptMagazineId", column = @Column(name = "Script_Magazine_id", nullable = false)) })
	public ProofreadId getId() {
		return this.id;
	}

	public void setId(ProofreadId id) {
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

	@Column(name = "proof_addr")
	public String getProofAddr() {
		return this.proofAddr;
	}

	public void setProofAddr(String proofAddr) {
		this.proofAddr = proofAddr;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "proof_date", length = 10)
	public Date getProofDate() {
		return this.proofDate;
	}

	public void setProofDate(Date proofDate) {
		this.proofDate = proofDate;
	}

	@Column(name = "proof_rank")
	public Integer getProofRank() {
		return this.proofRank;
	}

	public void setProofRank(Integer proofRank) {
		this.proofRank = proofRank;
	}

	@Column(name = "proof_state", length = 45)
	public String getProofState() {
		return this.proofState;
	}

	public void setProofState(String proofState) {
		this.proofState = proofState;
	}

}
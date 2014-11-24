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
 * Proofread entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "proofread", catalog = "mydb")
public class Proofread implements java.io.Serializable {

	// Fields

	private Integer id;
	private Script script;
	private String proofPath;
	private Date proofDate;
	private Integer proofRank;
	private String proofState;
	private Integer staffId;

	// Constructors

	/** default constructor */
	public Proofread() {
	}

	/** minimal constructor */
	public Proofread(Script script) {
		this.script = script;
	}

	/** full constructor */
	public Proofread(Script script, String proofPath, Date proofDate,
			Integer proofRank, String proofState, Integer staffId) {
		this.script = script;
		this.proofPath = proofPath;
		this.proofDate = proofDate;
		this.proofRank = proofRank;
		this.proofState = proofState;
		this.staffId = staffId;
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

	@Column(name = "proof_path")
	public String getProofPath() {
		return this.proofPath;
	}

	public void setProofPath(String proofPath) {
		this.proofPath = proofPath;
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

	@Column(name = "Staff_id")
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

}
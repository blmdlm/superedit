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
 * Compose entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "compose", catalog = "mydb")
public class Compose implements java.io.Serializable {

	// Fields

	private Integer id;
	private Script script;
	private String composePath;
	private Date composeDate;
	private Integer composeState;
	private Integer staffId;

	// Constructors

	/** default constructor */
	public Compose() {
	}

	/** minimal constructor */
	public Compose(Script script) {
		this.script = script;
	}

	/** full constructor */
	public Compose(Script script, String composePath, Date composeDate,
			Integer composeState, Integer staffId) {
		this.script = script;
		this.composePath = composePath;
		this.composeDate = composeDate;
		this.composeState = composeState;
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

	@Column(name = "Compose_path")
	public String getComposePath() {
		return this.composePath;
	}

	public void setComposePath(String composePath) {
		this.composePath = composePath;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Compose_date", length = 10)
	public Date getComposeDate() {
		return this.composeDate;
	}

	public void setComposeDate(Date composeDate) {
		this.composeDate = composeDate;
	}

	@Column(name = "Compose_state")
	public Integer getComposeState() {
		return this.composeState;
	}

	public void setComposeState(Integer composeState) {
		this.composeState = composeState;
	}

	@Column(name = "Staff_id")
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

}
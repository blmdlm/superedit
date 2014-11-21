package dao;

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
 * Compose entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "compose", catalog = "mydb")
public class Compose implements java.io.Serializable {

	// Fields

	private ComposeId id;
	private Staff staff;
	private Script script;
	private String composeAddr;
	private Date composeDate;
	private Integer composeState;

	// Constructors

	/** default constructor */
	public Compose() {
	}

	/** minimal constructor */
	public Compose(ComposeId id, Staff staff, Script script) {
		this.id = id;
		this.staff = staff;
		this.script = script;
	}

	/** full constructor */
	public Compose(ComposeId id, Staff staff, Script script,
			String composeAddr, Date composeDate, Integer composeState) {
		this.id = id;
		this.staff = staff;
		this.script = script;
		this.composeAddr = composeAddr;
		this.composeDate = composeDate;
		this.composeState = composeState;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "staffId", column = @Column(name = "Staff_id", nullable = false)),
			@AttributeOverride(name = "scriptId", column = @Column(name = "Script_id", nullable = false)),
			@AttributeOverride(name = "scriptAuthorId", column = @Column(name = "Script_Author_id", nullable = false)),
			@AttributeOverride(name = "scriptMagazineId", column = @Column(name = "Script_Magazine_id", nullable = false)) })
	public ComposeId getId() {
		return this.id;
	}

	public void setId(ComposeId id) {
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

	@Column(name = "Compose_Addr")
	public String getComposeAddr() {
		return this.composeAddr;
	}

	public void setComposeAddr(String composeAddr) {
		this.composeAddr = composeAddr;
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

}
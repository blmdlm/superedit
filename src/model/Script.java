package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Script entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "script", catalog = "mydb")
public class Script implements java.io.Serializable {

	// Fields

	private Integer id;
	private Magazine magazine;
	private Author author;
	private String title;
	private String path;
	private Integer state;
	private Integer progress;
	private String summary;
	private Date date;
	private Integer distributor;
	private Set<Proofread> proofreads = new HashSet<Proofread>(0);
	private Set<Compose> composes = new HashSet<Compose>(0);
	private Set<Audit> audits = new HashSet<Audit>(0);

	// Constructors

	/** default constructor */
	public Script() {
	}

	/** minimal constructor */
	public Script(Author author) {
		this.author = author;
	}

	/** full constructor */
	public Script(Magazine magazine, Author author, String title, String path,
			Integer state, Integer progress, String summary, Date date,
			Integer distributor, Set<Proofread> proofreads,
			Set<Compose> composes, Set<Audit> audits) {
		this.magazine = magazine;
		this.author = author;
		this.title = title;
		this.path = path;
		this.state = state;
		this.progress = progress;
		this.summary = summary;
		this.date = date;
		this.distributor = distributor;
		this.proofreads = proofreads;
		this.composes = composes;
		this.audits = audits;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Magazine_id")
	public Magazine getMagazine() {
		return this.magazine;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Author_id", nullable = false)
	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "path")
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "progress")
	public Integer getProgress() {
		return this.progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	@Column(name = "summary", length = 65535)
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "distributor")
	public Integer getDistributor() {
		return this.distributor;
	}

	public void setDistributor(Integer distributor) {
		this.distributor = distributor;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "script")
	public Set<Proofread> getProofreads() {
		return this.proofreads;
	}

	public void setProofreads(Set<Proofread> proofreads) {
		this.proofreads = proofreads;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "script")
	public Set<Compose> getComposes() {
		return this.composes;
	}

	public void setComposes(Set<Compose> composes) {
		this.composes = composes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "script")
	public Set<Audit> getAudits() {
		return this.audits;
	}

	public void setAudits(Set<Audit> audits) {
		this.audits = audits;
	}

}
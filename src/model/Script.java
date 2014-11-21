package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Script entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "script", catalog = "mydb")
public class Script implements java.io.Serializable {

	// Fields

	private ScriptId id;
	private Magazine magazine;
	private Author author;
	private String title;
	private String path;
	private Integer price;
	private Integer reject;
	private Integer state;
	private Set<Proofread> proofreads = new HashSet<Proofread>(0);
	private Set<Compose> composes = new HashSet<Compose>(0);
	private Set<Audit> audits = new HashSet<Audit>(0);

	// Constructors

	/** default constructor */
	public Script() {
	}

	/** minimal constructor */
	public Script(ScriptId id, Magazine magazine, Author author) {
		this.id = id;
		this.magazine = magazine;
		this.author = author;
	}

	/** full constructor */
	public Script(ScriptId id, Magazine magazine, Author author, String title,
			String path, Integer price, Integer reject, Integer state,
			Set<Proofread> proofreads, Set<Compose> composes, Set<Audit> audits) {
		this.id = id;
		this.magazine = magazine;
		this.author = author;
		this.title = title;
		this.path = path;
		this.price = price;
		this.reject = reject;
		this.state = state;
		this.proofreads = proofreads;
		this.composes = composes;
		this.audits = audits;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "authorId", column = @Column(name = "Author_id", nullable = false)),
			@AttributeOverride(name = "magazineId", column = @Column(name = "Magazine_id", nullable = false)) })
	public ScriptId getId() {
		return this.id;
	}

	public void setId(ScriptId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Magazine_id", nullable = false, insertable = false, updatable = false)
	public Magazine getMagazine() {
		return this.magazine;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Author_id", nullable = false, insertable = false, updatable = false)
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

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "reject")
	public Integer getReject() {
		return this.reject;
	}

	public void setReject(Integer reject) {
		this.reject = reject;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
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
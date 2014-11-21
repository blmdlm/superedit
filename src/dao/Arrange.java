package dao;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Arrange entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "arrange", catalog = "mydb")
public class Arrange implements java.io.Serializable {

	// Fields

	private ArrangeId id;
	private Author author;
	private Staff staff;
	private String arrangeTitle;
	private String arrangeContent;
	private Date arrangeDate;

	// Constructors

	/** default constructor */
	public Arrange() {
	}

	/** minimal constructor */
	public Arrange(ArrangeId id, Author author, Staff staff) {
		this.id = id;
		this.author = author;
		this.staff = staff;
	}

	/** full constructor */
	public Arrange(ArrangeId id, Author author, Staff staff,
			String arrangeTitle, String arrangeContent, Date arrangeDate) {
		this.id = id;
		this.author = author;
		this.staff = staff;
		this.arrangeTitle = arrangeTitle;
		this.arrangeContent = arrangeContent;
		this.arrangeDate = arrangeDate;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "authorId", column = @Column(name = "Author_id", nullable = false)),
			@AttributeOverride(name = "staffId", column = @Column(name = "Staff_id", nullable = false)) })
	public ArrangeId getId() {
		return this.id;
	}

	public void setId(ArrangeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Author_id", nullable = false, insertable = false, updatable = false)
	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Staff_id", nullable = false, insertable = false, updatable = false)
	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Column(name = "arrange_title")
	public String getArrangeTitle() {
		return this.arrangeTitle;
	}

	public void setArrangeTitle(String arrangeTitle) {
		this.arrangeTitle = arrangeTitle;
	}

	@Column(name = "arrange_content", length = 65535)
	public String getArrangeContent() {
		return this.arrangeContent;
	}

	public void setArrangeContent(String arrangeContent) {
		this.arrangeContent = arrangeContent;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "arrange_date", length = 10)
	public Date getArrangeDate() {
		return this.arrangeDate;
	}

	public void setArrangeDate(Date arrangeDate) {
		this.arrangeDate = arrangeDate;
	}

}
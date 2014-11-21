package dao;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Messageboard entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "messageboard", catalog = "mydb")
public class Messageboard implements java.io.Serializable {

	// Fields

	private MessageboardId id;
	private Author author;
	private String query;
	private String reply;

	// Constructors

	/** default constructor */
	public Messageboard() {
	}

	/** minimal constructor */
	public Messageboard(MessageboardId id, Author author) {
		this.id = id;
		this.author = author;
	}

	/** full constructor */
	public Messageboard(MessageboardId id, Author author, String query,
			String reply) {
		this.id = id;
		this.author = author;
		this.query = query;
		this.reply = reply;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "authorId", column = @Column(name = "Author_id", nullable = false)) })
	public MessageboardId getId() {
		return this.id;
	}

	public void setId(MessageboardId id) {
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

	@Column(name = "query", length = 65535)
	public String getQuery() {
		return this.query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@Column(name = "reply", length = 65535)
	public String getReply() {
		return this.reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

}
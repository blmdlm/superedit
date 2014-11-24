package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Messageboard entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "messageboard", catalog = "mydb")
public class Messageboard implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer sendId;
	private String content;
	private Date time;
	private Integer parentid;

	// Constructors

	/** default constructor */
	public Messageboard() {
	}

	/** full constructor */
	public Messageboard(Integer sendId, String content, Date time,
			Integer parentid) {
		this.sendId = sendId;
		this.content = content;
		this.time = time;
		this.parentid = parentid;
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

	@Column(name = "send_id")
	public Integer getSendId() {
		return this.sendId;
	}

	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "time", length = 10)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "parentid")
	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

}
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
	private Date sendTime;
	private Integer parentid;
	@Override
	public String toString() {
		return "Messageboard [id=" + id + ", sendId=" + sendId + ", content="
				+ content + ", sendTime=" + sendTime + ", parentid=" + parentid
				+ ", type=" + type + ", staffId=" + staffId + ", auditStatus="
				+ auditStatus + ", replyStatus=" + replyStatus + "]";
	}

	private Integer type;
	private Integer staffId;
	private Integer auditStatus;
	private Integer replyStatus;

	// Constructors

	/** default constructor */
	public Messageboard() {
	}

	/** full constructor */
	public Messageboard(Integer sendId, String content, Date sendTime,
			Integer parentid, Integer type, Integer staffId,
			Integer auditStatus, Integer replyStatus) {
		this.sendId = sendId;
		this.content = content;
		this.sendTime = sendTime;
		this.parentid = parentid;
		this.type = type;
		this.staffId = staffId;
		this.auditStatus = auditStatus;
		this.replyStatus = replyStatus;
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
	@Column(name = "send_time", length = 10)
	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@Column(name = "parentid")
	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "staff_id")
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Column(name = "audit_status")
	public Integer getAuditStatus() {
		return this.auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	@Column(name = "reply_status")
	public Integer getReplyStatus() {
		return this.replyStatus;
	}

	public void setReplyStatus(Integer replyStatus) {
		this.replyStatus = replyStatus;
	}

}
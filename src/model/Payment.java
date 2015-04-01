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
 * Payment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "payment", catalog = "mydb")
public class Payment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer scriptId;
	private Integer staffId;
	private Integer magazineId;
	private Integer cost;
	private Integer state;
	private Date deliverDate;
	private Date payDate;

	// Constructors

	/** default constructor */
	public Payment() {
	}

	/** minimal constructor */
	public Payment(Integer scriptId) {
		this.scriptId = scriptId;
	}

	/** full constructor */
	public Payment(Integer scriptId, Integer staffId, Integer magazineId,
			Integer cost, Integer state, Date deliverDate, Date payDate) {
		this.scriptId = scriptId;
		this.staffId = staffId;
		this.magazineId = magazineId;
		this.cost = cost;
		this.state = state;
		this.deliverDate = deliverDate;
		this.payDate = payDate;
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

	@Column(name = "script_id", nullable = false)
	public Integer getScriptId() {
		return this.scriptId;
	}

	public void setScriptId(Integer scriptId) {
		this.scriptId = scriptId;
	}

	@Column(name = "staff_id")
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Column(name = "magazine_id")
	public Integer getMagazineId() {
		return this.magazineId;
	}

	public void setMagazineId(Integer magazineId) {
		this.magazineId = magazineId;
	}

	@Column(name = "cost")
	public Integer getCost() {
		return this.cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "deliver_date", length = 10)
	public Date getDeliverDate() {
		return this.deliverDate;
	}

	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "pay_date", length = 10)
	public Date getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

}
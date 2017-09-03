package evolution.entity.one2Many;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {// Transaction entity owns the relationship.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Date transactionTime;
	@ManyToOne
	@JoinColumn(name = "user_id")// Foreign Key
	private User user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
}

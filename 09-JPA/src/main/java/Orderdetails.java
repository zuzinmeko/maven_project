

import java.io.Serializable;
import javax.persistence.*;

import com.mmit.OrderdetailPk;

/**
 * Entity implementation class for Entity: Orderdetails
 *
 */
@Entity
public class Orderdetails implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderdetailPk id;
	private int subQty;
	private int subPrice;
	

	public OrderdetailPk getId() {
		return id;
	}


	public void setId(OrderdetailPk id) {
		this.id = id;
	}


	public int getSubQty() {
		return subQty;
	}


	public void setSubQty(int subQty) {
		this.subQty = subQty;
	}


	public int getSubPrice() {
		return subPrice;
	}


	public void setSubPrice(int subPrice) {
		this.subPrice = subPrice;
	}


	public Orderdetails() {
		super();
	}
   
}

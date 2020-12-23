package com.mmit;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderdetailPk  implements Serializable{

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		result = prime * result + orderId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderdetailPk other = (OrderdetailPk) obj;
		if (itemId != other.itemId)
			return false;
		if (orderId != other.orderId)
			return false;
		return true;
	}
	private static final long serialVersionUID = 1L;
	
	private int itemId;
	private int orderId;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
}

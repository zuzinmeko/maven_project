package com.mmit;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Township;
	private String Street;
	private String City;
	
	
	public String getTownship() {
		return Township;
	}
	public void setTownship(String township) {
		Township = township;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((City == null) ? 0 : City.hashCode());
		result = prime * result + ((Street == null) ? 0 : Street.hashCode());
		result = prime * result + ((Township == null) ? 0 : Township.hashCode());
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
		Address other = (Address) obj;
		if (City == null) {
			if (other.City != null)
				return false;
		} else if (!City.equals(other.City))
			return false;
		if (Street == null) {
			if (other.Street != null)
				return false;
		} else if (!Street.equals(other.Street))
			return false;
		if (Township == null) {
			if (other.Township != null)
				return false;
		} else if (!Township.equals(other.Township))
			return false;
		return true;
	}
	
	
	
}

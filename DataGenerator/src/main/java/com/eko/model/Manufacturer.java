package com.eko.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Manufacturer {
	@XmlElement
	private String manufacturerId;
	@XmlElement
	private String manufacturerName;
	@XmlElement
	private String manufacturerLocation;

	public String getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerLocation() {
		return manufacturerLocation;
	}

	public void setManufacturerLocation(String manufacturerLocation) {
		this.manufacturerLocation = manufacturerLocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manufacturerId == null) ? 0 : manufacturerId.hashCode());
		result = prime * result + ((manufacturerLocation == null) ? 0 : manufacturerLocation.hashCode());
		result = prime * result + ((manufacturerName == null) ? 0 : manufacturerName.hashCode());
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
		Manufacturer other = (Manufacturer) obj;
		if (manufacturerId == null) {
			if (other.manufacturerId != null)
				return false;
		} else if (!manufacturerId.equals(other.manufacturerId))
			return false;
		if (manufacturerLocation == null) {
			if (other.manufacturerLocation != null)
				return false;
		} else if (!manufacturerLocation.equals(other.manufacturerLocation))
			return false;
		if (manufacturerName == null) {
			if (other.manufacturerName != null)
				return false;
		} else if (!manufacturerName.equals(other.manufacturerName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manufacturer [manufacturerId=" + manufacturerId + ", manufacturerName=" + manufacturerName
				+ ", manufacturerLocation=" + manufacturerLocation + "]";
	}

}

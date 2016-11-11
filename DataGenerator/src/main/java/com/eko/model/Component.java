package com.eko.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Component {
	@XmlElement
	private String componentId;
	@XmlElement
	private String componentType;
	@XmlElement
	private Integer componentUnit;
	@XmlElement
	private Date stockDate;
	private List<Manufacturer> manufacturer = new ArrayList<>();

	public String getComponentId() {
		return componentId;
	}

	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	public String getComponentType() {
		return componentType;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	public Integer getComponentUnit() {
		return componentUnit;
	}

	public void setComponentUnit(Integer componentUnit) {
		this.componentUnit = componentUnit;
	}

	public Date getStockDate() {
		return stockDate;
	}

	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componentId == null) ? 0 : componentId.hashCode());
		result = prime * result + ((componentType == null) ? 0 : componentType.hashCode());
		result = prime * result + ((componentUnit == null) ? 0 : componentUnit.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((stockDate == null) ? 0 : stockDate.hashCode());
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
		Component other = (Component) obj;
		if (componentId == null) {
			if (other.componentId != null)
				return false;
		} else if (!componentId.equals(other.componentId))
			return false;
		if (componentType == null) {
			if (other.componentType != null)
				return false;
		} else if (!componentType.equals(other.componentType))
			return false;
		if (componentUnit == null) {
			if (other.componentUnit != null)
				return false;
		} else if (!componentUnit.equals(other.componentUnit))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (stockDate == null) {
			if (other.stockDate != null)
				return false;
		} else if (!stockDate.equals(other.stockDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Component [componentId=" + componentId + ", componentType=" + componentType + ", componentUnit="
				+ componentUnit + ", stockDate=" + stockDate + ", manufacturer=" + manufacturer + "]";
	}

	public List<Manufacturer> getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(List<Manufacturer> manufacturer) {
		this.manufacturer = manufacturer;
	}

}

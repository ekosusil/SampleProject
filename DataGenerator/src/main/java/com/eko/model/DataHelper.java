package com.eko.model;

public class DataHelper {
	private String manufacturerId;
	private String manufacturerName;
	private String manufacturerLocation;
	private String productId;
	private String productName;
	private String productType;
	private Integer productUnits;
	private String componentId;
	private String componentType;
	private Integer componentUnits;
	private String stockDate;

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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Integer getProductUnits() {
		return productUnits;
	}

	public void setProductUnits(Integer productUnits) {
		this.productUnits = productUnits;
	}

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

	public Integer getComponentUnits() {
		return componentUnits;
	}

	public void setComponentUnits(Integer componentUnits) {
		this.componentUnits = componentUnits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componentId == null) ? 0 : componentId.hashCode());
		result = prime * result + ((componentType == null) ? 0 : componentType.hashCode());
		result = prime * result + ((componentUnits == null) ? 0 : componentUnits.hashCode());
		result = prime * result + ((manufacturerId == null) ? 0 : manufacturerId.hashCode());
		result = prime * result + ((manufacturerLocation == null) ? 0 : manufacturerLocation.hashCode());
		result = prime * result + ((manufacturerName == null) ? 0 : manufacturerName.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((productUnits == null) ? 0 : productUnits.hashCode());
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
		DataHelper other = (DataHelper) obj;
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
		if (componentUnits == null) {
			if (other.componentUnits != null)
				return false;
		} else if (!componentUnits.equals(other.componentUnits))
			return false;
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
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (productUnits == null) {
			if (other.productUnits != null)
				return false;
		} else if (!productUnits.equals(other.productUnits))
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
		return "DataHelper [manufacturerId=" + manufacturerId + ", manufacturerName=" + manufacturerName
				+ ", manufacturerLocation=" + manufacturerLocation + ", productId=" + productId + ", productName="
				+ productName + ", productType=" + productType + ", productUnits=" + productUnits + ", componentId="
				+ componentId + ", componentType=" + componentType + ", componentUnits=" + componentUnits + "]";
	}

	public String getStockDate() {
		return stockDate;
	}

	public void setStockDate(String stockDate) {
		this.stockDate = stockDate;
	}

}

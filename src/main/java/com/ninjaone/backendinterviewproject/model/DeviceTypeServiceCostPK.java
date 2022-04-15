/**
 * 
 */
package com.ninjaone.backendinterviewproject.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author sebas
 *
 */
@Embeddable
public class DeviceTypeServiceCostPK implements Serializable {
	
	/**
	 * Serialization ID.
	 */
	private static final long serialVersionUID = 8582428272202107776L;
	

	@ManyToOne
	@JoinColumn(name = "device_id", nullable = false, foreignKey = @ForeignKey(name = "FK_device_type"))
	private DeviceType deviceType;

	@ManyToOne
	@JoinColumn(name = "service_id", nullable = false, foreignKey = @ForeignKey(name = "FK_device_service"))
	private DeviceService deviceService;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deviceType == null) ? 0 : deviceType.hashCode());
		result = prime * result + ((deviceService == null) ? 0 : deviceService.hashCode());
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
		DeviceTypeServiceCostPK other = (DeviceTypeServiceCostPK) obj;
		if (deviceType == null) {
			if (other.deviceType != null)
				return false;
		} else if (!deviceType.equals(other.deviceType))
			return false;
		if (deviceService == null) {
			if (other.deviceService != null)
				return false;
		} else if (!deviceService.equals(other.deviceService))
			return false;
		return true;
	}

}

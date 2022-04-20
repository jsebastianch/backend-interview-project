/**
 * 
 */
package com.ninjaone.backendinterviewproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import com.ninjaone.backendinterviewproject.service.impl.DeviceServiceImpl;

/**
 * @author sebas
 *
 */
@ExtendWith(MockitoExtension.class)
public class DeviceServiceTest {

	public static final Integer ID = 1;

	public static final String NAME = "System Name";

	@Mock
	private DeviceRepository deviceRepository;
	@InjectMocks
	private DeviceService deviceService = new DeviceServiceImpl();

	private Device device;
	
	private final DeviceType deviceType = new DeviceType(ID, "Windows", new BigDecimal(4));

	@BeforeEach
	void setup() {
		device = new Device(ID, NAME, deviceType);
	}

	@Test
	void shouldThrowExceptionOnInsertingWhenRepeatedName() {
		when(deviceRepository.findBySystemNameIgnoreCase(NAME))
				.thenReturn(Arrays.asList(device, device, device));
		assertThrows(Exception.class, () -> {
			this.deviceService.insert(new Device(null, NAME, deviceType));
		});
	}

	@Test
	void shouldReturnEntityWhenInsertingAndNoRepeatedName() throws Exception {
		Device ds = new Device(null, NAME, deviceType);
		when(deviceRepository.findBySystemNameIgnoreCase(NAME)).thenReturn(new ArrayList<>());
		when(this.deviceRepository.save(ds)).thenReturn(device);
		assertEquals(device, this.deviceService.insert(ds));
	}
	
	
	@Test
	void shouldThrowExceptionOnUpdatingWhenRepeatedName() {
		when(deviceRepository.findBySystemNameIgnoreCase(NAME))
				.thenReturn(Arrays.asList(device, device, device));
		assertThrows(Exception.class, () -> {
			this.deviceService.update(new Device(2, NAME, deviceType));
		});
	}

	@Test
	void shouldReturnEntityWhenUpdatingAndNoRepeatedName() throws Exception {
		Device ds = new Device(ID, NAME, deviceType);
		when(deviceRepository.findBySystemNameIgnoreCase(NAME)).thenReturn(new ArrayList<>());
		when(this.deviceRepository.save(ds)).thenReturn(device);
		assertEquals(device, this.deviceService.update(ds));
	}

}

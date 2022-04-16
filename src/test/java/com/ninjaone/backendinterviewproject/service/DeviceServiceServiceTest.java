/**
 * 
 */
package com.ninjaone.backendinterviewproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ninjaone.backendinterviewproject.database.DeviceServiceRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.DeviceService;
import com.ninjaone.backendinterviewproject.service.impl.CRUDImpl;
import com.ninjaone.backendinterviewproject.service.impl.DeviceServiceServiceImpl;

import lombok.extern.log4j.Log4j2;

/**
 * @author sebas
 *
 */
@ExtendWith(MockitoExtension.class)
public class DeviceServiceServiceTest {

	public static final Integer ID = 1;

	public static final String NAME = "Service Name";

	@Mock
	private DeviceServiceRepository deviceServiceRepository;
	@InjectMocks
	private DeviceServiceService deviceServiceService = new DeviceServiceServiceImpl();

	private DeviceService deviceService;

	@BeforeEach
	void setup() {
		deviceService = new DeviceService(ID, NAME);
	}

	@Test
	void shouldThrowExceptionOnInsertingWhenRepeatedName() {
		when(deviceServiceRepository.findByNameIgnoreCase(NAME))
				.thenReturn(Arrays.asList(deviceService, deviceService, deviceService));
		assertThrows(Exception.class, () -> {
			this.deviceServiceService.insertDeviceService(new DeviceService(null, NAME));
		});
	}

	@Test
	void shouldReturnEntityWhenInsertingAndNoRepeatedName() throws Exception {
		DeviceService ds = new DeviceService(null, NAME);
		when(deviceServiceRepository.findByNameIgnoreCase(NAME)).thenReturn(new ArrayList<>());
		when(this.deviceServiceService.insert(ds)).thenReturn(deviceService);
		assertEquals(deviceService, this.deviceServiceService.insertDeviceService(ds));
	}

}

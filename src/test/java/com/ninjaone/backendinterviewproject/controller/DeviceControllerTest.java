package com.ninjaone.backendinterviewproject.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninjaone.backendinterviewproject.BackendInterviewProjectApplication;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import com.ninjaone.backendinterviewproject.service.DeviceService;
import com.ninjaone.backendinterviewproject.service.DeviceTypeService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { BackendInterviewProjectApplication.class })
@WebMvcTest(DeviceController.class)
@AutoConfigureMockMvc
@AutoConfigureDataJpa
public class DeviceControllerTest {
	public static final Integer ID = 1;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	private DeviceService deviceService;

	@MockBean
	private DeviceTypeService deviceTypeService;

	@MockBean
	private UserDetailsService userDetailsService;

	private final DeviceType deviceType = new DeviceType(ID, "Windows", new BigDecimal(4));

	private Device device;

	@BeforeEach
	void setup() {
		device = new Device(ID, "Windows Workstation", deviceType);
	}

	@Test
	void getDevice() throws Exception {
		when(this.deviceService.findById(ID)).thenReturn(device);
		mockMvc.perform(get("/device/" + ID)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string(objectMapper.writeValueAsString(device)));
	}

	@Test
	void postDevice() throws Exception {
		when(this.deviceService.insert(any())).thenReturn(device);
		String deviceEntityString = objectMapper.writeValueAsString(device);
		mockMvc.perform(post("/device/").contentType(MediaType.APPLICATION_JSON).content(deviceEntityString))
				.andExpect(status().isCreated());
	}

	@Test
	void putDevice() throws Exception {
		when(this.deviceService.findById(ID)).thenReturn(device);
		Device updatedDevice = new Device(ID, "new Windows Workstation", deviceType);
		when(this.deviceService.update(any())).thenReturn(updatedDevice);
		String deviceEntityString = objectMapper.writeValueAsString(updatedDevice);
		mockMvc.perform(put("/device/").contentType(MediaType.APPLICATION_JSON).content(deviceEntityString))
				.andExpect(status().isOk()).andExpect(content().string(deviceEntityString));
	}

	@Test
	void deleteDevice() throws Exception {
		doNothing().when(this.deviceService).delete(ID);
		mockMvc.perform(delete("/device/" + ID)).andExpect(status().isNoContent());
	}
}

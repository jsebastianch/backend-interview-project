package com.ninjaone.backendinterviewproject.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.ninjaone.backendinterviewproject.model.DeviceService;
import com.ninjaone.backendinterviewproject.service.DeviceServiceService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { BackendInterviewProjectApplication.class })
@WebMvcTest(DeviceServiceController.class)
@AutoConfigureMockMvc
@AutoConfigureDataJpa
public class DeviceServiceControllerTest {
	public static final Integer ID = 1;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	private DeviceServiceService deviceServiceService;

	private DeviceService service;

	@MockBean
	private UserDetailsService userDetailsService;

	@BeforeEach
	void setup() {
		service = new DeviceService(ID, "Antivirus");
	}

	@Test
	void postSampleData() throws Exception {
		when(this.deviceServiceService.insertDeviceService(any())).thenReturn(service);
		String serviceEntityString = objectMapper.writeValueAsString(service);
		mockMvc.perform(post("/service/").contentType(MediaType.APPLICATION_JSON).content(serviceEntityString))
				.andExpect(status().isCreated());
	}

	@Test
	void deleteSampleData() throws Exception {
		doNothing().when(this.deviceServiceService).delete(ID);
		mockMvc.perform(delete("/service/" + ID)).andExpect(status().isNoContent());
	}
}

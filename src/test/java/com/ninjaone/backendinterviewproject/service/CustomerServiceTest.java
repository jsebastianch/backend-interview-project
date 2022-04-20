/**
 * 
 */
package com.ninjaone.backendinterviewproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ninjaone.backendinterviewproject.database.CustomerRepository;
import com.ninjaone.backendinterviewproject.model.Customer;
import com.ninjaone.backendinterviewproject.model.CustomerDeviceService;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.DeviceService;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import com.ninjaone.backendinterviewproject.model.DeviceTypeServiceCost;
import com.ninjaone.backendinterviewproject.service.impl.CustomerServiceImpl;

/**
 * @author Sebastian
 *
 */
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	
	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private CustomerDeviceServiceService customerDeviceServiceService;

	@Mock
	private DeviceTypeServiceCostService deviceTypeServiceCostService;

	@InjectMocks
	private CustomerService customerService = new CustomerServiceImpl();

	private DeviceType windowsWorkstation = new DeviceType(1, "Windows Workstation", new BigDecimal(4));
	private DeviceType windowsServer = new DeviceType(2, "Windows Server", new BigDecimal(4));
	private DeviceType mac = new DeviceType(3, "Mac", new BigDecimal(4));

	private List<Device> devices;
	private List<DeviceService> services;
	private List<CustomerDeviceService> customerServices;

	private Customer customer = new Customer(1, "Customer 1");

	@BeforeEach
	void setup() {
		this.devices = new ArrayList<>();
		this.devices.add(new Device(1, "Windows PC", windowsWorkstation));
		this.devices.add(new Device(2, "Windows SRVR", windowsServer));
		this.devices.add(new Device(3, "MAC 1", mac));
		this.devices.add(new Device(4, "MAC 2", mac));
		this.devices.add(new Device(5, "MAC 3", mac));

		this.services = new ArrayList<>();
		this.services.add(new DeviceService(1, "Antivirus"));
		this.services.add(new DeviceService(2, "Backup"));
		this.services.add(new DeviceService(4, "Screen Share"));

		this.customerServices = new ArrayList<>();
		int deviceServiceId = 1;
		for (Device device : devices) {
			for (DeviceService deviceService : this.services) {
				CustomerDeviceService cds = new CustomerDeviceService();
				cds.setId(deviceServiceId);
				cds.setCustomer(this.customer);
				cds.setDevice(device);
				cds.setDeviceService(deviceService);
				this.customerServices.add(cds);
				deviceServiceId++;
			}
		}

	}

	@Test
	void shouldReturnCorrectCalculatedCost() throws Exception {
		when(this.customerRepository.findById(this.customer.getId())).thenReturn(Optional.of(this.customer));
		when(this.customerDeviceServiceService.findDistinctDeviceByCustomer(this.customer)).thenReturn(this.devices);
		when(this.customerDeviceServiceService.findByCustomer(customer)).thenReturn(this.customerServices);
		when(this.deviceTypeServiceCostService.findOneByDeviceTypeAndDeviceService(any(DeviceType.class),
				any(DeviceService.class))).thenAnswer(invocation -> {
					DeviceType deviceType = (DeviceType) invocation.getArguments()[0];
					DeviceService deviceService = (DeviceService) invocation.getArguments()[1];
					DeviceTypeServiceCost cost = new DeviceTypeServiceCost();
					cost.setDeviceType(deviceType);
					cost.setDeviceService(deviceService);
					if (deviceService.getId().compareTo(1) == 0
							&& (deviceType.equals(windowsWorkstation) || deviceType.equals(windowsServer))) {
						cost.setCost(new BigDecimal(5));
					} else if (deviceService.getId().compareTo(1) == 0 && deviceType.equals(mac)) {
						cost.setCost(new BigDecimal(7));
					} else if (deviceService.getId().compareTo(2) == 0) {
						cost.setCost(new BigDecimal(3));
					} else {
						cost.setCost(new BigDecimal(1));
					}
					return cost;
				});
		assertEquals(new BigDecimal(71),
				this.customerService.calculateCustomerMonthlyCost(customer.getId()).getTotalCost());
	}

}

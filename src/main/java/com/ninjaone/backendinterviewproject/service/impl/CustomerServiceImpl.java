/**
 * 
 */
package com.ninjaone.backendinterviewproject.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninjaone.backendinterviewproject.database.CustomerRepository;
import com.ninjaone.backendinterviewproject.database.IGenericRepo;
import com.ninjaone.backendinterviewproject.dto.CustomerCostDetailDTO;
import com.ninjaone.backendinterviewproject.dto.CustomerDeviceDTO;
import com.ninjaone.backendinterviewproject.dto.CustomerDeviceServiceDTO;
import com.ninjaone.backendinterviewproject.model.Customer;
import com.ninjaone.backendinterviewproject.model.CustomerDeviceService;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.DeviceTypeServiceCost;
import com.ninjaone.backendinterviewproject.service.CustomerDeviceServiceService;
import com.ninjaone.backendinterviewproject.service.CustomerService;
import com.ninjaone.backendinterviewproject.service.DeviceTypeServiceCostService;

import lombok.extern.log4j.Log4j2;

/**
 * @author Sebastian
 *
 */
@Log4j2
@Service
public class CustomerServiceImpl extends CRUDImpl<Customer, Integer> implements CustomerService {

	@Autowired
	private CustomerRepository repo;

	@Autowired
	private CustomerDeviceServiceService customerDeviceServiceService;

	@Autowired
	private DeviceTypeServiceCostService deviceTypeServiceCostService;

	@Override
	protected IGenericRepo<Customer, Integer> getRepo() {
		return this.repo;
	}

	@Override
	public CustomerCostDetailDTO calculateCustomerMonthlyCost(Integer id) throws Exception {
		Customer customer = this.findById(id);
		CustomerCostDetailDTO customerCostDetailDTO = new CustomerCostDetailDTO();
		customerCostDetailDTO.setCustomerId(customer.getId());
		customerCostDetailDTO.setCustomerName(customer.getName());
		customerCostDetailDTO.setDevices(new ArrayList<>());
		List<Device> devices = this.customerDeviceServiceService.findDistinctDeviceByCustomer(customer);
		List<CustomerDeviceService> serviceList = this.customerDeviceServiceService.findByCustomer(customer);
		customerCostDetailDTO.setTotalCost(BigDecimal.ZERO);
		for (Device device : devices) {
			log.info("Device: "+device+" cost:"+ device.getType().getCost());
			List<CustomerDeviceService> deviceServices = serviceList.stream()
					.filter(service -> service.getDevice().equals(device)).collect(Collectors.toList());
			customerCostDetailDTO.setTotalCost(customerCostDetailDTO.getTotalCost().add(device.getType().getCost()));
			customerCostDetailDTO.getDevices()
					.add(new CustomerDeviceDTO(device.getId(), device.getSystemName(), device.getType().getName(),
							device.getType().getCost(),
							this.getCustomerDeviceServiceDTOList(deviceServices, customerCostDetailDTO)));

		}
		
		return customerCostDetailDTO;
	}

	/**
	 * Gets a list of CustomerDeviceServiceDTO that represents the customer device services.
	 * @param deviceServices device services to be transformed
	 * @param customerCostDetailDTO to calculate the total cost
	 * @return a list of CustomerDeviceServiceDTO
	 */
	private List<CustomerDeviceServiceDTO> getCustomerDeviceServiceDTOList(List<CustomerDeviceService> deviceServices,
			CustomerCostDetailDTO customerCostDetailDTO) {
		List<CustomerDeviceServiceDTO> dtos = new ArrayList<>();
		for (CustomerDeviceService customerDeviceService : deviceServices) {
			DeviceTypeServiceCost deviceTypeServiceCost = this.deviceTypeServiceCostService
					.findOneByDeviceTypeAndDeviceService(customerDeviceService.getDevice().getType(),
							customerDeviceService.getDeviceService());
			BigDecimal serviceCost = deviceTypeServiceCost.getCost();
			log.info("Service: "+deviceTypeServiceCost.getDeviceService().getName()+" cost:"+ deviceTypeServiceCost.getCost());
			customerCostDetailDTO.setTotalCost(customerCostDetailDTO.getTotalCost().add(serviceCost));
			dtos.add(new CustomerDeviceServiceDTO(customerDeviceService.getDeviceService().getName(), serviceCost));
		}
		return dtos;
	}

}

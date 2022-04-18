/**
 * 
 */
package com.ninjaone.backendinterviewproject.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ninjaone.backendinterviewproject.dto.IdNameDTO;
import com.ninjaone.backendinterviewproject.model.DeviceService;
import com.ninjaone.backendinterviewproject.service.DeviceServiceService;

/**
 * @author sebas
 *
 */
@RestController
@RequestMapping("/service")
public class DeviceServiceController {

	@Autowired
	private DeviceServiceService deviceServiceService;

	@GetMapping("/")
	public ResponseEntity<List<DeviceService>> getDeviceServices() throws Exception {
		List<DeviceService> list = this.deviceServiceService.findAll();
		return new ResponseEntity<List<DeviceService>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DeviceService> getDeviceService(@PathVariable("id") Integer id) throws Exception {
		DeviceService DeviceService = this.deviceServiceService.findById(id);
		return new ResponseEntity<DeviceService>(DeviceService, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<DeviceService> addDeviceService(@RequestBody IdNameDTO dto) throws Exception {
		DeviceService service = this.deviceServiceService.insert(new DeviceService(null, dto.getName()));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(service.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteService(@PathVariable("id") Integer id) throws Exception{
		this.deviceServiceService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<DeviceService> updateDeviceService(@RequestBody IdNameDTO dto) throws Exception {
		DeviceService service = this.deviceServiceService.update(new DeviceService(dto.getId(), dto.getName()));
		return new ResponseEntity<DeviceService>(service, HttpStatus.OK);
	}

}

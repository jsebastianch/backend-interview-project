/**
 * 
 */
package com.ninjaone.backendinterviewproject.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ninjaone.backendinterviewproject.dto.DeviceDTO;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import com.ninjaone.backendinterviewproject.service.DeviceService;
import com.ninjaone.backendinterviewproject.service.DeviceTypeService;

/**
 * @author sebas
 *
 */
@RestController
@RequestMapping("/device")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;
	@Autowired
	private DeviceTypeService deviceTypeService;

	@GetMapping("/")
	public ResponseEntity<List<Device>> getDevices() throws Exception {
		List<Device> list = this.deviceService.findAll();
		return new ResponseEntity<List<Device>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Device> getDevice(@PathVariable("id") Integer id) throws Exception {
		Device Device = this.deviceService.findById(id);
		return new ResponseEntity<Device>(Device, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Device> addDevice(@RequestBody DeviceDTO dto) {
		try {
			DeviceType dt = this.deviceTypeService.findById(dto.getDeviceTypeId());
			Device service = this.deviceService.insert(new Device(null, dto.getName(), dt));
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(service.getId()).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception exc) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, exc.getMessage(), exc);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteService(@PathVariable("id") Integer id) throws Exception {
		try {
			this.deviceService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (DataIntegrityViolationException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage(), e);
		} catch (EmptyResultDataAccessException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	@PutMapping
	public ResponseEntity<Device> updateDevice(@RequestBody DeviceDTO dto) {
		try {
			DeviceType dt = this.deviceTypeService.findById(dto.getDeviceTypeId());
			Device service = this.deviceService.update(new Device(dto.getId(), dto.getName(), dt));
			return new ResponseEntity<Device>(service, HttpStatus.OK);
		} catch (Exception exc) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, exc.getMessage(), exc);
		}
	}

}

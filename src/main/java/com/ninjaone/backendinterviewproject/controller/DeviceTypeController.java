/**
 * 
 */
package com.ninjaone.backendinterviewproject.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ninjaone.backendinterviewproject.dto.IdNameDTO;
import com.ninjaone.backendinterviewproject.model.DeviceType;
import com.ninjaone.backendinterviewproject.service.DeviceTypeService;

/**
 * @author sebas
 *
 */
@RestController
@RequestMapping("/type")
public class DeviceTypeController {

	@Autowired
	private DeviceTypeService deviceTypeService;

	@GetMapping("/")
	public ResponseEntity<List<DeviceType>> getDevices() throws Exception {
		List<DeviceType> lista = this.deviceTypeService.findAll();
		return new ResponseEntity<List<DeviceType>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DeviceType> getDevice(@PathVariable("id") Integer id) throws Exception {
		DeviceType device = this.deviceTypeService.findById(id);
		return new ResponseEntity<DeviceType>(device, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<DeviceType> registrar(@RequestBody IdNameDTO dto) throws Exception {
		DeviceType type = this.deviceTypeService.insert(new DeviceType(null, dto.getName()));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(type.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}

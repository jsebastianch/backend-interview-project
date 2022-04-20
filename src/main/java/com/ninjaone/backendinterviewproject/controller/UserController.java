/**
 * 
 */
package com.ninjaone.backendinterviewproject.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ninjaone.backendinterviewproject.dto.UserDTO;
import com.ninjaone.backendinterviewproject.model.User;
import com.ninjaone.backendinterviewproject.service.UserService;

/**
 * @author Sebastian
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	

	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Object> postSampleEntity(@RequestBody UserDTO userDTO) throws Exception{
		User user = new User();
		user.setUserName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
        user = this.userService.insert(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build();
    }
}

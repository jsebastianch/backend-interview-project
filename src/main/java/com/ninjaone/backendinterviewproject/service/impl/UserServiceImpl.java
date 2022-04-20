package com.ninjaone.backendinterviewproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ninjaone.backendinterviewproject.database.IGenericRepo;
import com.ninjaone.backendinterviewproject.database.UserRepository;
import com.ninjaone.backendinterviewproject.model.User;
import com.ninjaone.backendinterviewproject.service.UserService;

@Service
public class UserServiceImpl extends CRUDImpl<User, Integer> implements UserDetailsService,  UserService{

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User usuario = this.repo.findOneByUserName(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(String.format("User not found", username));
		}
		List<GrantedAuthority> roles = new ArrayList<>();
		usuario.getRoles().forEach(rol -> {
			roles.add(new SimpleGrantedAuthority(rol.getName()));
		});
		UserDetails ud = new org.springframework.security.core.userdetails.User(usuario.getUserName(),
				usuario.getPassword(), roles);
		return ud;
	}

	@Override
	protected IGenericRepo<User, Integer> getRepo() {
		return this.repo;
	}

	@Override
	public User insert(User t) throws Exception {
		t.setPassword(this.bcrypt.encode(t.getPassword()));
		t.setEnabled(true);
		return super.insert(t);
	}

}

package models.service.security;

import models.SecurityUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServiceUserDetail implements UserDetailsService {

	private Assembler assembler;

	@Autowired
	private ServiceSecurityUser serviceSecurityUser;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecurityUser user = serviceSecurityUser.findByEmail(username);
		if (user == null)
			throw new UsernameNotFoundException("Usuario incorrecto.");
		assembler = new Assembler();
		return assembler.buildUserFromUserEntity(user);
	}
}
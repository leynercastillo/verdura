package models.service.security;

import java.util.ArrayList;
import java.util.Collection;

import models.SecurityGroup;
import models.SecurityRole;
import models.SecurityUser;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("assembler")
public class Assembler {

	@Transactional(readOnly = true)
	public User buildUserFromUserEntity(SecurityUser userModel) {
		/* Datos basicos del usuario */
		String username = userModel.getEmail();
		String password = userModel.getPassword();
		boolean enabled = userModel.getStatus() == 'A' ? true : false;
		boolean accountNonExpired = userModel.getStatus() == 'A' ? true : false;
		boolean credentialsNonExpired = userModel.getStatus() == 'A' ? true : false;
		boolean accountNonLocked = userModel.getStatus() == 'A' ? true : false;
		/* Recolectamos los roles del usuario */
		Collection<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		for (SecurityGroup auxSecurityGroup : userModel.getSecurityGroups()) {
			for (SecurityRole auxSecurityRole : auxSecurityGroup.getSecurityRoles()) {
				roles.add(new SimpleGrantedAuthority(auxSecurityRole.getName()));
			}
		}
		User user = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, roles);
		return user;
	}
}
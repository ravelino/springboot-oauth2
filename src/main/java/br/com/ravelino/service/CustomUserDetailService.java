/**
 * 
 */
package br.com.ravelino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.ravelino.model.Login;
import br.com.ravelino.repository.LoginRepository;

/**
 * @author ravelino
 *
 */

@Component
public class CustomUserDetailService implements UserDetailsService {
	
	private final LoginRepository repository;
	
	@Autowired
	public CustomUserDetailService(LoginRepository loginRepository) {
		repository = loginRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Login l = Optional.ofNullable(repository.findByLogin(login)).orElseThrow(() -> new UsernameNotFoundException("Nao encontrou usuario"));
		List<GrantedAuthority> authoritiesAdmin = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
		List<GrantedAuthority> authoritiesUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		return new User(l.getLogin(), l.getPassword(), authoritiesUser);
	}


}

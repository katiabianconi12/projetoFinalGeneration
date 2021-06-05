package com.gamificacao.projetogamificacao.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gamificacao.projetogamificacao.models.Usuario;
import com.gamificacao.projetogamificacao.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<Usuario> user = userRepository.findByUsuarioOrEmail(userName, userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found. "));
		
		return user.map(UserDetailsImpl::new).get();
	}
	
}

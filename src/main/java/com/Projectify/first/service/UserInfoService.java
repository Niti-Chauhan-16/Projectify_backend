package com.Projectify.first.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Projectify.first.Repository.UserRepository;
import com.Projectify.first.model.User;
import com.Projectify.first.model.UserInfo;

@Service
@Component
public class UserInfoService  implements UserDetailsService{
	
	
	private UserRepository user;
	
	@Autowired
	public void setUser(UserRepository user) {
		this.user=user;
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    User u=user.FindByUsername(username);
	    
	    if(user==null) throw new UsernameNotFoundException("Invalid user");
	    
	    return new UserInfo(u);
	    
	}

}

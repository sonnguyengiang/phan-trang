package code.services;


import code.model.Account;
import code.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    IAccountRepo iAccountRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = iAccountRepo.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(user.getAccountRole());

        UserDetails userDetails = new User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );

        return userDetails ;
    }
}

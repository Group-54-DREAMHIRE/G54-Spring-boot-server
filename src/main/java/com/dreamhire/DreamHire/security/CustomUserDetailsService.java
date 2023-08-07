package com.dreamhire.DreamHire.security;

import com.dreamhire.DreamHire.model.SystemUser;
import com.dreamhire.DreamHire.repository.SystemUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService  implements UserDetailsService {

    private SystemUserRepo systemUserRepo;

    @Autowired
    public CustomUserDetailsService(SystemUserRepo systemUserRepo) {
        this.systemUserRepo = systemUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SystemUser user = systemUserRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
//        return  new User(user.getUsername(), user.getPassword(),  user.getRole());
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getUserType().toString())  // Provide the necessary authorities/roles
                .build();
    }
//
//    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }

}

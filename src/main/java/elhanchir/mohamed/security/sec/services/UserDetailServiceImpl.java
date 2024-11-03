package elhanchir.mohamed.security.sec.services;

import elhanchir.mohamed.security.sec.entities.AppRole;
import elhanchir.mohamed.security.sec.entities.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor

public class UserDetailServiceImpl implements UserDetailsService {
    private AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            AppUser user = accountService.loadUserByUsername(username);
            if(user==null) throw new UsernameNotFoundException("Invalid user");

            UserDetails userDetails = User
                    .withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRoles().stream().map(AppRole::getRoleName).toArray(String[]::new))
                    .build();
            return userDetails;
        }

}

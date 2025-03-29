package lk.ijse.cmjd109.jwtauthenticationproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


// 02.02
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    // Username--->
    // <---return UserDetails
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = User.builder()
                .username("dassana")
                .password(passwordEncoder.encode("dassana"))
                .build();
        return user;
    }

}

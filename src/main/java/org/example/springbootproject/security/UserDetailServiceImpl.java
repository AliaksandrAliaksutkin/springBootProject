package org.example.springbootproject.security;

import lombok.RequiredArgsConstructor;
import org.example.springbootproject.model.User;
import org.example.springbootproject.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service("userDetailsServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
        User user = userRepository.findByFirstName(firstName).orElseThrow(() ->
                new UsernameNotFoundException("Пользователь не обнаружен"));
        return SecurityUser.fromUser(user);
    }
}

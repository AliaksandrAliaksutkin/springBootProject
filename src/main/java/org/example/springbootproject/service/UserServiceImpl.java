package org.example.springbootproject.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootproject.exception.NoEntityException;
import org.example.springbootproject.model.User;
import org.example.springbootproject.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService /*,UserDetailsService*/ {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User getById(Long id) throws NoEntityException {
        return userRepository.findById(id).orElseThrow(() -> new NoEntityException(id));
    }
//    public User findByFirstName(String firstName){
//        return userRepository.findByFirstName(firstName);
//
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = findByFirstName(username);
//        if(user == null){
//            throw new UsernameNotFoundException(String.format("User '%s' not found",username));
//        }
//        return new org.springframework.security.core.userdetails.User(user.getFirstName(),user.getPassword(),
//        mapRolesAutorithies(user.getRole()));
//    }
//
//    private Collection<? extends GrantedAuthority> mapRolesAutorithies(Collection<Role> roles){
//        return roles.stream().map(r->new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
//    }
}

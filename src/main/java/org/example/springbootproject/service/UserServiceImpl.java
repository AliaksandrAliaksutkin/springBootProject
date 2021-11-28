package org.example.springbootproject.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootproject.exception.NoEntityException;
import org.example.springbootproject.model.User;
import org.example.springbootproject.repository.UserRepository;
import org.example.springbootproject.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public User save(User user) {
        return userRepository.saveAndFlush(user);  //todo зачем saveAndFlush? какое он тебе даст здесь преимущество
    }                                               // для принудительной синхронизации состояния юзера с БД

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

        @Override
        public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
            User user = userRepository.findByFirstName(firstName).orElseThrow(() ->
                    new UsernameNotFoundException("Пользователь не обнаружен"));
            return SecurityUser.fromUser(user);
        }

}

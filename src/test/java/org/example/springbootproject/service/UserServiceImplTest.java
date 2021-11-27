package org.example.springbootproject.service;


import org.example.springbootproject.model.Address;
import org.example.springbootproject.model.User;
import org.example.springbootproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

//    @Mock
//    private UserRepository userRepository;
//
//    @Test
//    void save() {
//        User user = new User(1L, "Aliaksandr", "Aliaksutkin", 33
//                , new Address("Bereza", "Komsomolskaya", 52));
//        when(userRepository.saveAndFlush(user)).thenReturn(user);
//
//        assertEquals(user, userRepository.saveAndFlush(user));
//        verify(userRepository, times(1)).saveAndFlush(user);
//    }
//
//    @Test
//    void getAllUsers() {
//        List<User> loserList = List.of(
//                new User(1L, "Aliaksandr", "Aliaksutkin", 33
//                        , new Address("Bereza", "Komsomolskaya", 52)),
//                new User(2L, "Aliaksandr", "Aliaksutkin", 33
//                        , new Address("Bereza", "Komsomolskaya", 52)));
//
//        when(userRepository.findAll()).thenReturn(loserList);
//        assertEquals(loserList, userRepository.findAll());
//        verify(userRepository, times(1)).findAll();
//
//    }
//
//    @Test
//    void getById() {
//        List<User> loserList = List.of(
//                new User(1L, "Aliaksandr", "Aliaksutkin", 33
//                        , new Address("Bereza", "Komsomolskaya", 52)),
//                new User(2L, "Aliaksandr", "Aliaksutkin", 33
//                        , new Address("Bereza", "Komsomolskaya", 52)));
//
//        when(userRepository.findById(1L)).thenReturn(Optional.of(loserList.get(0)));
//        assertNotEquals(loserList.get(1), userRepository.findById(1L));
//        verify(userRepository, times(1)).findById(1L);
//    }
//
//    @Test
//    void deleteById() {
//        userRepository.deleteById(1L);
//        verify(userRepository,times(1)).deleteById(1L);
//    }
}

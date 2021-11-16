package org.example.springbootproject.service;


import org.example.springbootproject.model.Address;
import org.example.springbootproject.model.User;
import org.example.springbootproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) /*регитрация расширения Mockito для дальнейшей инициализации @Mock или  @InjectMocks*/
public class UserServiceImplTest {
    UserService userService;
    /*@Test
    public void substring(){
        assertEquals("llo","Hello".substring(3));
    }
    один из дурацких примеров*/

    @Mock
    private UserRepository userRepository;
    /*@Mock создает макет.
    @InjectMocks создает экземпляр класса и внедряет в этот экземпляр макеты, созданные с помощью аннотаций @Mock(или @Spy).*/
    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    void save() {
        User user = new User("Aliaksandr", "Aliaksutkin", 33
                ,new Address("Bereza","Komsomolskaya",52));
        when(userRepository.save(user))
                .thenReturn(user);
//        assertNotEquals(user,userServiceImpl.save(user));
        assertEquals(user,userServiceImpl.save(user));
//        assertSame(user,userServiceImpl.save(user));
//        assertNotSame(user,userServiceImpl.save(user));
        verify(userRepository.save(user));
    }

}

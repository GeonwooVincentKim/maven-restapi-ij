package io.gw.rest.service.logic;

import io.gw.rest.entity.User;
import io.gw.rest.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceLogicTest {
    @Autowired
    private UserService userService;

    private User kim;
    private User lee;

    // The Function that is called before the Unit Test is executed
    @BeforeEach
    public void startUp() {

    }

    @Test
    public void registerTest() {
        User sample = User.sample();
//        this.userService.register(sample);
        assertThat(this.userService.register(sample)).isEqualTo(sample.getId());
        assertThat(this.userService.findAll().size()).isEqualTo(1);
    }

    @Test
    public void find() {

    }

    // The Function that is called after the Unit Test is executed
    @AfterEach
    public void cleanUp() {
        //
    }
}

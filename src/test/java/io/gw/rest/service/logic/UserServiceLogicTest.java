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
        this.kim = new User("Kim", "kim@test.com");
        this.lee = new User("Lee", "lee@test.com");
        this.userService.register(kim);
        this.userService.register(lee);
    }

    @Test
    public void registerTest() {
        User sample = User.sample();
//        this.userService.register(sample);
        assertThat(this.userService.register(sample)).isEqualTo(sample.getId());
        assertThat(this.userService.findAll().size()).isEqualTo(3);
        this.userService.remove(sample.getId());
    }

    @Test
    public void find() {
        assertThat(this.userService.find(lee.getId())).isNotNull();
        assertThat(this.userService.find(lee.getId()).getEmail()).isEqualTo(lee.getEmail());
    }

    // The Function that is called after the Unit Test is executed
    @AfterEach
    public void cleanUp() {
        //
        this.userService.remove(kim.getId());
        this.userService.remove(lee.getId());
    }
}

package io.gw.rest.controller;

import io.gw.rest.entity.User;
import io.gw.rest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
* Controller
* The method takes a `Model` object as a parameter and adds an attribute called "message" to it
@Controller
public class MyController {

    @Autowired
    private MyService myService;

    @RequestMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("message", myService.getHelloMessage());
        return "hello";
    }
}
*
* RestController
* The method returns an object of the `Greeting` class, which will be automatically converted
* to a JSON or XML representation and sent as the response to the client
*
@RestController
public class MyRestController {

    @Autowired
    private MyService myService;

    @RequestMapping("/greeting")
    public Greeting getGreeting() {
        return myService.getGreeting();
    }
}
* */
@RestController
@RequiredArgsConstructor
public class UserController {
    // Client Proxy Origin
    // Client -> Get all Request from Proxy
    // Origin Server -> Give & Take data (JSON) between Proxy
    private final UserService userService;

    // When a request comes from a client, it comes in a Body
    @PostMapping("/users")
    public String register(@RequestBody User newUser) {
        return userService.register(newUser);
    }
}

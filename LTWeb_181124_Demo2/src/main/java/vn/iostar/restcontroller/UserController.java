package vn.iostar.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.iostar.entity.UserInfo;
import vn.iostar.service.UserService;

@Repository
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/new")
    public String newUser(@RequestBody UserInfo userInfo) {
        return userService.addUser(userInfo);
    }
}

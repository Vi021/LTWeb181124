package vn.iostar.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.iostar.entity.UserInfo;
import vn.iostar.repositoty.UserInfoRepository;

@Service
public record UserService(UserInfoRepository userInfoRepository, PasswordEncoder encoder) {
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));

        userInfoRepository.save(userInfo);

        return "User added";
    }
}

package vn.iostar.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.iostar.entity.UserInfo;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    Optional<UserInfo> findByName(String username);
}

package cn.jian.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cn.jian.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

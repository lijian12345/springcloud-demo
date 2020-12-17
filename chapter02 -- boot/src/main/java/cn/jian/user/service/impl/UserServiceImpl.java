package cn.jian.user.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.jian.user.dto.UserDto;
import cn.jian.user.entity.User;
import cn.jian.user.repository.UserRepository;
import cn.jian.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    protected UserRepository userRepository;

    @Override
    public Page<User> getPage(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public User load(Long id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    @Transactional
    public User save(UserDto userDto) {
        Optional<User> user = this.userRepository.findById(userDto.getId());
        if (user.isEmpty()) {
            user = Optional.of(new User());
        }
        user.get().setNickname(userDto.getNickname());
        user.get().setAvatar(userDto.getAvatar());
        return this.userRepository.save(user.get());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}

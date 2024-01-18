package com.sudal.mongodb.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public String create(String name) {
        User user = User.builder()
                .name(name)
                .build();

        return userRepository.save(user).getId();
    }

    public User read(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User update(String id, String name) {
        User user = userRepository.findById(id).orElse(null);

        assert user != null;
        user.setName(name);

        return userRepository.save(user);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
}

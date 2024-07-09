package Service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import Service.UserService;
import domain.model.User;
import domain.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);

    }

    // Verificação se o usuario que esta sendo criado ja existe no banco
    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists");
        }
        return userRepository.save(userToCreate);

    }

}

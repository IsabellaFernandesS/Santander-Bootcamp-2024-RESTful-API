package Service;

import domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);

}

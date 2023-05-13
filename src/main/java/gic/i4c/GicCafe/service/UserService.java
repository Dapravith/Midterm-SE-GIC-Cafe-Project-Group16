package gic.i4c.GicCafe.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import gic.i4c.GicCafe.model.User;

public interface UserService {
    User saveUser(User user, MultipartFile file);
    List<User> getAllUsers();
    User getUserById(Integer id);
    void deleteUser(Integer id);
}

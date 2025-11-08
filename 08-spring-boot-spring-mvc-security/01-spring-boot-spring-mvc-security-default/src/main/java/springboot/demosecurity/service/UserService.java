package springboot.demosecurity.service;

import springboot.demosecurity.entity.User;

public interface UserService {
    User save(User user);
    User update(User user);
}

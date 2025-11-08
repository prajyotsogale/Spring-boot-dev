package springboot.demosecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springboot.demosecurity.dao.AuthorityRepository;
import springboot.demosecurity.dao.UserRepository;
import springboot.demosecurity.entity.Authority;
import springboot.demosecurity.entity.User;

import javax.management.relation.RoleInfoNotFoundException;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthorityRepository authorityRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           AuthorityRepository authorityRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }
    @Override
    public User save(User user) {
        if(userRepository.existsByUsername(user.getUsername())){
            throw new RuntimeException("Username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Authority authority = new Authority();
        authority.setUserId(user.getUsername());
        authority.setRole("ROLE_EMPLOYEE");
        authorityRepository.save(authority);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }
}

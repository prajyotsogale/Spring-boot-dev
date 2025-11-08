package springboot.demosecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.demosecurity.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByUsername(String username);
}

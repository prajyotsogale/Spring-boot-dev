package springboot.demosecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.demosecurity.entity.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority , Integer> {
}

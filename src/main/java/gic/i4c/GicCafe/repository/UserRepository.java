package gic.i4c.GicCafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gic.i4c.GicCafe.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}

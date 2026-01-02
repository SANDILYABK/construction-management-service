package com.cm.admirable.dao;

import com.cm.admirable.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends JpaRepository<User, Long> {

    User save(User user);
    Optional<User> findById(Long id);
    User findByEmail(String email);
    boolean existsById(Long id);
    @Override
    List<User> findAllById(Iterable<Long> longs);
}

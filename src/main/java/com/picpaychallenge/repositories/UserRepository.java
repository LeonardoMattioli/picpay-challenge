package com.picpaychallenge.repositories;

import com.picpaychallenge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

package com.moviesexplorer.jpa;

import com.moviesexplorer.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

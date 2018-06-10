package com.assign1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assign1.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}

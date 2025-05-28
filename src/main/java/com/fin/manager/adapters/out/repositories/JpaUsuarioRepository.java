package com.fin.manager.adapters.out.repositories;

import com.fin.manager.adapters.out.entities.JpaUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface JpaUsuarioRepository extends JpaRepository<JpaUsuarioEntity, Long> {

    Optional<UserDetails> findByEmail(String email);
}

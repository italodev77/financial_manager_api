package com.fin.manager.domain.entity.user.repository;

import com.fin.manager.domain.entity.user.UsuarioCore;

import java.util.List;

public interface UsuarioCoreRepository {
    UsuarioCore save(UsuarioCore usuarioCore);

    UsuarioCore findById(Long id);

    List<UsuarioCore> findAll();

    void deleteById(Long id);
}

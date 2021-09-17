package com.SIGER.SIGER.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SIGER.SIGER.entities.Usuario;
import com.SIGER.SIGER.repositories.BaseRepository;
import com.SIGER.SIGER.repositories.UsuarioRepository;

import lombok.NoArgsConstructor;

@Service
//@Transactional
@NoArgsConstructor
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository) {
      super(baseRepository);
  }

}

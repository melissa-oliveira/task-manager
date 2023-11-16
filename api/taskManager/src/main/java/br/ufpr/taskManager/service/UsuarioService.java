package br.ufpr.taskManager.service;

import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufpr.taskManager.entity.Usuario;
import br.ufpr.taskManager.repository.UsuarioRepository;
import br.ufpr.taskManager.service.interfaces.IUsuarioService;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {		
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Integer id) {		
		return usuarioRepository.findById(id).get();	
	}
	
	public Usuario findByEmail(String email) {		
		return usuarioRepository.findByEmail(email);	
	}

	public Usuario create(Usuario entity) {		
		return usuarioRepository.save(entity);
	}

	public Usuario update(Usuario entity) {
		Usuario usuarioExistente = usuarioRepository.findById(entity.getId()).get();
		usuarioExistente.setNome(entity.getNome());
        usuarioExistente.setSenha(entity.getSenha());
        usuarioExistente.setEmail(entity.getEmail());
	    Usuario usuarioAtualizado = usuarioRepository.save(usuarioExistente);
		
		return usuarioAtualizado;
	}

	public void delete(Integer id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario login(String login, String senha) {
	    Usuario usuario = usuarioRepository.findByEmail(login);

	    if (usuario != null && usuario.getSenha().equals(this.hashSHA256(senha))) {
	        return usuario;
	    } else {
	        return null;
	    }
	}
	
    public String hashSHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

	
}
   
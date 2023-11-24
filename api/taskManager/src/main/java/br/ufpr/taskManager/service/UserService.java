package br.ufpr.taskManager.service;

import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufpr.taskManager.entity.User;
import br.ufpr.taskManager.repository.UserRepository;

@Service
@Transactional
public class UserService  {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {		
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {		
		return userRepository.findById(id).get();	
	}
	
	public User findByEmail(String email) {		
		return userRepository.findByEmail(email);	
	}

	public User create(User entity) {		
		return userRepository.save(entity);
	}

	public User update(User entity) {
		User existingUser = userRepository.findById(entity.getId()).get();
		existingUser.setName(entity.getName());
        existingUser.setPassword(entity.getPassword());
        existingUser.setEmail(entity.getEmail());

        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
	}

	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

	public User login(String login, String senha) {
	    User usuario = userRepository.findByEmail(login);

	    if (usuario != null && usuario.getPassword().equals(this.hashSHA256(senha))) {
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
   
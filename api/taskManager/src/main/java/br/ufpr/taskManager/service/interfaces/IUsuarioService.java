package br.ufpr.taskManager.service.interfaces;

import br.ufpr.taskManager.entity.Usuario;

public interface IUsuarioService extends IBaseService<Integer, Usuario> {
	Usuario findByEmail(String email);
}

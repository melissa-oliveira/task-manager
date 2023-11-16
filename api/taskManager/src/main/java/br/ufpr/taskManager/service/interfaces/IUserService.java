package br.ufpr.taskManager.service.interfaces;

import br.ufpr.taskManager.entity.User;

public interface IUserService extends IBaseService<Integer, User> {
	User findByEmail(String email);
}

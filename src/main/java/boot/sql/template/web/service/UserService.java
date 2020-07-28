package boot.sql.template.web.service;

import java.util.List;

import boot.sql.template.web.entity.User;

public interface UserService {

	public void save(User user);

	public User get(int id);

	public List<User> getAll();

	public void update(User user);

	public void delete(User user);

}

package boot.sql.template.web.dao;

import java.util.List;

import boot.sql.template.web.entity.User;

public interface UserDao {

	public void save(User user);

	public User get(int id);

	public List<User> getAll();

	public void update(User user);

	public void delete(User user);

}

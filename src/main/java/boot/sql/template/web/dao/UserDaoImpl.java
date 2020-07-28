package boot.sql.template.web.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boot.sql.template.web.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	private EntityManager entityManager;

	@Autowired
	public UserDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.save(user);
	}

	@Override
	public User get(int id) {
		Session session = entityManager.unwrap(Session.class);
		User user = session.get(User.class, id);
		return user;
	}

	@Override
	public List<User> getAll() {
		Session session = entityManager.unwrap(Session.class);
		org.hibernate.query.Query<User> query = session.createQuery("from User", User.class);
		List<User> users = query.getResultList();
		return users;
	}

	@Override
	public void update(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.update(user);
	}

	@Override
	public void delete(User user) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(user);
	}

}

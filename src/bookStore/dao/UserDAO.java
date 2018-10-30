package bookStore.dao;


import bookStore.domain.User;

public interface UserDAO {

	public abstract User getUser(String username);

}


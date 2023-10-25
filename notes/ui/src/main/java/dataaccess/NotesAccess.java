package dataaccess;

import core.User;

public interface NotesAccess {

	/**
	* Creates a new user and adds it to Accounts.
	*
	* @param user the user to create
	*/
	public void createUser(User user);
}

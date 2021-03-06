package eCommerce.business.concretes;

import java.util.List;

import eCommerce.business.abstracts.UserService;
import eCommerce.core.EmailService;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService {
	private UserDao userDao; 
	private EmailService emailService;
	public UserManager(UserDao userDao,EmailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService=emailService;
	}

	@Override
	public void add(User user) {
		if(userValidate(user)) {
			userDao.add(user);
			
			emailService.send(user.getEmail(), "kayıt başarılı oldu");
		}
		
		

	}

	@Override
	public void update(User user) {
		if(userValidate(user)) {
			userDao.update(user);
		}

	}

	@Override
	public void delete(int userId) {
		userDao.delete(userId);


	}

	@Override
	public User get(String email) {
		return userDao.get(email);
	}

	@Override
	public List<User> getAll() {
		for (User user : userDao.getAll()) {
			System.out.println(user.getFirstName() + " "+ user.getLastName() + " "+ user.getEmail());
		}
		return userDao.getAll();
	}
	

	public boolean userValidate(User user) {

		if (user.getFirstName().length() > 2 && user.getLastName().length() > 2) {
			return true;
		}
		System.out.println("Name and surname have at least 2 characters.");
		return false;
	}

}

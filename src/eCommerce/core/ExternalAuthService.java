package eCommerce.core;

import eCommerce.entities.concretes.LoginDto;

public interface ExternalAuthService {
	
	void register(String email);
	boolean userEx�sts(String email);
	void login(LoginDto dto);

}

package pe.edu.upc.spring.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.spring.model.Users;
import pe.edu.upc.spring.repository.IUserRepository;
import pe.edu.upc.spring.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository dUser;
	
	@Override
	@Transactional
	public boolean save(Users user) {
		Users objUser= dUser.save(user);
		if (objUser == null)
			return false;
		else
			return true;
	}


	@Override
	@Transactional(readOnly=true)
	public List<Users> findByEmailAndPassword(String email, String password) {
		return dUser.findByEmailAndPassword(email, password);
	}
	
}

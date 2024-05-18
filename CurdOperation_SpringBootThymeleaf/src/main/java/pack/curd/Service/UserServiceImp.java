package pack.curd.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.curd.Model.UserModel;

import pack.curd.Repository.LoginRepo;
import pack.curd.Repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository repo;
	
	public void save(UserModel user) {
		repo.save(user);
	}
	
	public List<UserModel> getallbook(){
		return repo.findAll();
	}

	
	public UserModel getbookbyid(int id) {
		return repo.findById(id).get();
	}
	
	
	public void deleteid(int id) {
		repo.deleteById(id);
	}
	



}
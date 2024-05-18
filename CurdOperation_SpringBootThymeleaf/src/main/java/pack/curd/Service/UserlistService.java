package pack.curd.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.curd.Model.UserModel;
import pack.curd.Model.Userlist;
import pack.curd.Repository.LoginRepo;

@Service
public class UserlistService {
	
	@Autowired
	LoginRepo repo;
	
	
	public void savebook(Userlist list) {
		repo.save(list);
	}
	
	public List<Userlist> getbooklist(){
		return repo.findAll();
	}
	
	public void deletebyidlist(int id) {
		repo.deleteById(id);
	}
	public Userlist getbookbyid(int id) {
		return repo.findById(id).get();
	}
	

}

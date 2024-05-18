package pack.curd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.curd.Model.UserModel;
import pack.curd.Model.Userlist;


public interface LoginRepo extends JpaRepository<Userlist,Integer>{
	
}

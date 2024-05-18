package pack.curd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import pack.curd.Model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Integer>{
	
	

}

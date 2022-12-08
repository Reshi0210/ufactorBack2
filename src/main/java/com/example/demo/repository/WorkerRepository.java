package com.example.demo.repository;




import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Worker;
import com.example.demo.models.sex;





@Repository
public interface WorkerRepository extends JpaRepository< Worker, Long> {
	
	
	
	public List<Worker> findByFirstNameContaining(@Param ("firstName") String firstName);
	
	public List<Worker> findBySex(sex sex);
	
	public List<Worker> findBySecondNameContaining(@Param ("secondName")String secondName);
	
	
	public List<Worker> findByFirstNameStartsWith(String criteria);
	
	public List<Worker> findByCiStartsWith(String criteria);
	
	
	
	
	

	
	
	
	
	
	

}

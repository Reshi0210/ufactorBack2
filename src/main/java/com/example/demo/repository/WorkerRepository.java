package com.example.demo.repository;




import java.util.List;


import com.example.demo.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkerRepository extends PagingAndSortingRepository< Worker, Long> {
	
	
	
	public List<Worker> findByFirstNameContaining(@Param ("firstName") String firstName);
	
	public List<Worker> findBySecondNameContaining(@Param ("secondName")String secondName);

	public List<Worker> findByFirstNameStartsWith(String criteria);
	
	public List<Worker> findByCiStartsWith(String criteria);


	@Query("select w from Worker w where  " +
			"(:ScholarLevel is null or w.scholarShip.ScholarLevel=:ScholarLevel )and" +
			"(:firstName is null or w.firstName like %:firstName%) and"+
			"(:secondName is null or w.secondName like %:secondName% )and"+
			"(:lastName is null or w.lastName like %:lastName%)and  "+
			"(:race is null or w.race =:race)and "+
			"(:contractType is null or w.contractType =:contractType)and"+
			"(:expedientNumber is null or w.expedientNumber=:expedientNumber)and"+
			"(:active is null or w.active=:active)and"+
			"(:sex is null or w.sex=:sex)and"+
			"(:defensePlace is null or w.defensePlace=:defensePlace) and"+
			"(:department is null or w.department.departamentName=:department) and " +
			"(w.age between :min and :max )"

	)
	public List<Worker> filter(@Param("ScholarLevel") scholarLevel ScholarLeve,
							   @Param("firstName") String firstName,
							   @Param("secondName") String secondName,
							   @Param("lastName") String lastName,
							   @Param("race") race race,
							   @Param("contractType") contractType contractType,
							   @Param("expedientNumber") String expedientNumber,
							   @Param("active") active active,
							   @Param("sex") sex sex,
							   @Param("defensePlace") defensePlace defensePlace,
							   @Param("department") String department,
							   @Param("min") Integer min,
							   @Param("max") Integer max


							   );













}

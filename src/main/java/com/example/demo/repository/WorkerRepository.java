package com.example.demo.repository;




import java.util.List;


import com.example.demo.models.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkerRepository extends PagingAndSortingRepository< Worker, Long> {
	
	
	
	public List<Worker> findByFirstNameContaining(@Param ("firstName") String firstName);
	
	public List<Worker> findBySecondNameContaining(@Param ("secondName")String secondName);


	@Query("select w from Worker w where " +
			"( w.firstName Like :criteria%) and " +
			"(:entidad='Osde'or w.entidad.name=:entidad)")
	public List<Worker> findByFirstNameStartsWith(@Param("criteria") String criteria,
												  @Param("entidad") String entidad);

	@Query("select w from Worker w where " +
			"( w.ci Like :criteria%) and " +
			"(:entidad='Osde'or w.entidad.name=:entidad)")
	public List<Worker> findByCiStartsWith(@Param("criteria") String criteria,
										   @Param("entidad") String entidad);


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
			"(w.age between :min and :max ) and " +
			"(:entidad='Osde' or w.entidad.name=:entidad) "

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
							   @Param("max") Integer max,
							   @Param("entidad") String entidad


							   );



	  @Query("select w from Worker  w  where " +
			  " ((w.careerPlan.doctoradoF=:scholarship ) or" +
			  " (w.careerPlan.masterF=:scholarship ) or" +
			  " (w.careerPlan.posgrado1F=:scholarship ) or" +
			  " (w.careerPlan.posgrado2F=:scholarship ) or" +
			  " (w.careerPlan.formacionPiramidalF=:scholarship ) or" +
			  " (w.careerPlan.IdiomaOptimoF=:scholarship ) or" +
			  " (w.careerPlan.idiomaelementalF=:scholarship ) ) and"+
			 " (:entidad='Osde' or w.entidad.name=:entidad)"

			  )
      public List<Worker> filterByNed(@Param("scholarship")Scholarship scholarship,
	                                         @Param("entidad") String entidad);



      @Query("select w from Worker  w  where w.entidad.name=:entidad")
	  public Page<Worker> filterByEntidad(@Param("entidad") String entidad, PageRequest pageRequest);


}

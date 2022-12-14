package utilities;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class AgeUtilities {
	
	 

	public static Integer CalculateAge(String ci) {
		
		


		Integer Year = Integer.parseInt(ci.substring(0, 2));
		
		Integer month = Integer.parseInt(ci.substring(2, 4));
		
		Integer day= Integer.parseInt(ci.substring(4, 6));

		Integer CurrentYear = LocalDateTime.now().getYear();
		
		Integer CurrentMonth = LocalDateTime.now().getMonthValue();
		
		Integer CurrentDay = LocalDateTime.now().getDayOfMonth();
		
		Integer age=(CurrentYear - Year)%100;
		
		if(CurrentMonth<month)
			age--;
		if(month==CurrentMonth&&CurrentDay<day)
			age--;
		
		

		return age;
	}
	
	public static Boolean Between(Integer min,Integer max,Integer age) {
		
		return min<=age && age<=max;}
	

}

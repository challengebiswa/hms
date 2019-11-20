package org.hms.serviceapp.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:specialist.properties")
@ConfigurationProperties(prefix="hms")
public class SpecialistDtls {

	private List<SpecialistInformation> specialistInformation=new ArrayList<>();
	
	public List<SpecialistInformation> getSpecialistInformation() {
		return specialistInformation;
	}
	
	public void setSpecialistInformation(List<SpecialistInformation> specialistInformation) {
		this.specialistInformation = specialistInformation;
	}


	public static class SpecialistInformation {
        private String name;
        private String day;
        private String time;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDay() {
			return day;
		}
		public void setDay(String day) {
			this.day = day;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}

      
    }
	
}

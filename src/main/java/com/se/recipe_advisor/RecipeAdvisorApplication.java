package com.se.recipe_advisor;

import com.se.recipe_advisor.Utils.ReadJSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RecipeAdvisorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeAdvisorApplication.class, args);
	}



}

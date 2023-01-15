package org.example.covidapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.example.covidapi.TokenBucket.UserBucketCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidApiApplication.class, args);
		UserBucketCreator userBucketCreator = new UserBucketCreator(1);
        ExecutorService executors = Executors.newFixedThreadPool(12);
        for(int i=0;i<12;i++){
           executors.execute(() -> userBucketCreator.accessApplication(1));

        }
        executors.shutdown();
	}

}

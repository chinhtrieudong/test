package com.techlearn;

import com.techlearn.service.SampleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechLearnApplication implements CommandLineRunner {

    @Autowired
    private SampleDataService sampleDataService;

    public static void main(String[] args) {
        SpringApplication.run(TechLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sampleDataService.addSampleData();
    }
}

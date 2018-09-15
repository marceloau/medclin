package br.com.medclin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "br.com.medclin" }, exclude = JpaRepositoriesAutoConfiguration.class)
@EntityScan(basePackages = { "br.com.medclin.model" })
@EnableJpaRepositories(basePackages = { "br.com.medclin.repository" })
public class MedclinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedclinApplication.class, args);
	}
}

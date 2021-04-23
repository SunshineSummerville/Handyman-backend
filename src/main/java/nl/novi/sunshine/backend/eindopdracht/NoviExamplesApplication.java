package nl.novi.sunshine.backend.eindopdracht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NoviExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoviExamplesApplication.class, args);
	}

//	@GetMapping("/")
//	public String say_hello() {
//		return "Hello world!!!";
//	}

}

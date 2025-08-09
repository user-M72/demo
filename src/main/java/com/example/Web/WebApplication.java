package com.example.Web;

import com.example.Web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(){
//		return args -> {
//            var user=new UserEntity();
//			user.setUsername(UUID.randomUUID().toString());
//			user.setUserpassword(UUID.randomUUID().toString());
//
//			var role=new RoleEntity();
//			role.setRoleName(ERole.ADMIN.toString());
//
//			user.addRole(role);
//			userRepository.save(user);
//        };
//	}

}

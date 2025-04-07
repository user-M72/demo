package com.example.Web;

import com.example.Web.entity.ERole;
import com.example.Web.entity.RoleEntity;
import com.example.Web.entity.UserEntity;
import com.example.Web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

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
//			role.setRoleName(ERole.BLOGGER.toString());
//
//			user.addRole(role);
//			userRepository.save(user);
//        };
//	}

}

package com.example.blog_project;

import com.example.blog_project.Entity.UserEntity;
import com.example.blog_project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogProjectApplication {

  @Autowired
  static
  UserService userService;

  public static void main(String[] args) {
    SpringApplication.run(BlogProjectApplication.class, args);
  }

}

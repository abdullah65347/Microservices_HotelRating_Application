package com.userService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="user_service_table")
@Data
public class User {
	@Id
	private String userId;
	private String name;
	private String email;
	private String about;
	
	
	
	
	
}

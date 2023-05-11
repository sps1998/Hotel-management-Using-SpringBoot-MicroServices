package com.lcdw.user.service.entities;



import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {
	@Id
	@Column(name = "userId")
	private String userId;

	@Column(name = "name", length = 65555)
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "about")
	private String about;
	
	 @Transient
     private List<Rating> rating = new ArrayList<>();
	
	
}

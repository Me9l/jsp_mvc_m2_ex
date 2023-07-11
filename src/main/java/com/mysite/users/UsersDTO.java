package com.mysite.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class UsersDTO {
	String id;
	String pw;
	String name;
	String role;
}

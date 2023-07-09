package jp.te4a.spring.boot.myapp13Update.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class UserBean {
	@Id
	@Column(name="username", nullable = false)
	private String username;
	
	@JsonIgnore
	@Column(name="password", nullable = false)
	private String password;
	
}

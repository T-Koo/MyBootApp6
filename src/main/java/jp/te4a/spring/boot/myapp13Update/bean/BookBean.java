package jp.te4a.spring.boot.myapp13Update.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBean {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	
	@Column(name="title", nullable = false)
	private String title;
	
	@Column(name="writter")
	private String writter;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="price")
	private Integer price;
}
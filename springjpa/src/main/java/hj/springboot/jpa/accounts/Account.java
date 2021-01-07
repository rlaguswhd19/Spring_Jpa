package hj.springboot.jpa.accounts;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Account {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	private LocalDate created = LocalDate.now();
	
	@OneToMany(mappedBy = "owner")
	private Set<Study> studys = new HashSet<>();
	
	@Embedded
	private Address address;
	
	@Transient
	private String trash;
}

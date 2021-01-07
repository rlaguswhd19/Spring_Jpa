package hj.springboot.jpa.accounts;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	
	private String city;
	
	private String state;
	
}

package pl.spring.demo.to;

import org.springframework.stereotype.Component;

@Component("authorTo")
public class AuthorTo {
	private Long id;
    private String firstName;
	private String lastName;
    
	public AuthorTo() {}

    public AuthorTo(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public AuthorTo(String author) {
		String[] authorSplitted = author.split(" ");
		if(authorSplitted.length == 3) {
			this.id = Long.parseLong(authorSplitted[0]);
			this.firstName = authorSplitted[1];
			this.lastName = authorSplitted[2];
		}
	}
	
	public String toString() {
		return firstName + " " + lastName;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

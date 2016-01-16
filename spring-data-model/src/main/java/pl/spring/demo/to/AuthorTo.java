package pl.spring.demo.to;

public class AuthorTo {
	private Long id;
    private String firstName;
    public AuthorTo(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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

	private String lastName;

	public AuthorTo() {
		// TODO Auto-generated constructor stub
	}

}

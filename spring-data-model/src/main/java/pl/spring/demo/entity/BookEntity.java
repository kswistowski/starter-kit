package pl.spring.demo.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import pl.spring.demo.to.AuthorTo;

@Component("bookEntity")
public class BookEntity {
	private Long id;
	private String title;
	private List<AuthorTo> authors;

	public BookEntity(Long id, String title, List<AuthorTo> authors) {
		super();
		this.id = id;
		this.title = title;
		this.authors = authors;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}

	public final List<AuthorTo> getAuthors() {
		return authors;
	}

	public final void setAuthors(List<AuthorTo> authors) {
		this.authors = authors;
	}
}

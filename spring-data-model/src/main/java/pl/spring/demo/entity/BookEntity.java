package pl.spring.demo.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.IdAware;

@Component("bookEntity")
public class BookEntity implements IdAware {
	private Long id;
	private String title;
	private List<AuthorTo> authors;

	public BookEntity() {
	}
	
	public BookEntity(Long id, String title, String author) {
		this.id = id;
		this.title = title;
		this.authors = new ArrayList<AuthorTo>();
		this.authors.add(new AuthorTo(author));
	}
	
	public BookEntity(Long id, String title, List<AuthorTo> authors) {
		this.id = id;
		this.title = title;
		this.authors = authors;
	}

	@Override
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

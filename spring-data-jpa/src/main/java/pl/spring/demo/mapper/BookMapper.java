package pl.spring.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookTo;

@Component
public class BookMapper {
	public static BookTo map(BookEntity bookEntity) throws NullPointerException {
		if(bookEntity == null)
			throw new NullPointerException();
		StringBuilder sb = new StringBuilder();
		for(AuthorTo author : bookEntity.getAuthors()) {
			sb.append(author);
		}
		
		return new BookTo(bookEntity.getId(), bookEntity.getTitle(), sb.toString());
	}
	
	public static BookEntity map(BookTo bookTo) throws NullPointerException {
		if(bookTo == null)
			throw new NullPointerException();
		
		return new BookEntity(bookTo.getId(), bookTo.getTitle(), bookTo.getAuthors());
	}
	
	public static List<BookTo> map2To(List<BookEntity> bookEntities) {
		List<BookTo> listBookTows = new ArrayList<BookTo>();
		for(BookEntity bookEntity : bookEntities) {
			listBookTows.add(BookMapper.map(bookEntity));
		}
        return listBookTows;
    }

    public static List<BookEntity> map2Entity(List<BookTo> bookTows) {
    	List<BookEntity> listBookEntities = new ArrayList<BookEntity>();
		for(BookTo bookTo : bookTows) {
			listBookEntities.add(BookMapper.map(bookTo));
		}
        return listBookEntities;
    }
}

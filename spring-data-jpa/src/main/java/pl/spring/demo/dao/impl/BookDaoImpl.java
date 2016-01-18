package pl.spring.demo.dao.impl;

import pl.spring.demo.annotation.NullableId;
import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.BookDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.AuthorTo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDaoImpl implements BookDao {

    private final Set<BookEntity> ALL_BOOKS = new HashSet<>();

    private final Sequence sequence;

    @Autowired
    public BookDaoImpl( Sequence sequence) {
    	this.sequence = sequence;
        addTestBooks();
    }

    @Override
    public List<BookEntity> findAll() {
        return new ArrayList<>(ALL_BOOKS);
    }

    @Override
    public List<BookEntity> findBookByTitle(String title) {
    	ArrayList<BookEntity> foundedBooks = new ArrayList<BookEntity>();
    	for(BookEntity bookEntity : ALL_BOOKS) {
    		if(bookEntity.getTitle().equalsIgnoreCase(title)) {
    			 foundedBooks.add(bookEntity);
    		}
    	}
        return foundedBooks;
    }

    @Override
    public List<BookEntity> findBooksByAuthor(String author) {
    	ArrayList<BookEntity> foundedBooks = new ArrayList<BookEntity>();
    	for(BookEntity bookEntity : ALL_BOOKS) {
    		for(AuthorTo authorTo : bookEntity.getAuthors()) {
    			if(authorTo.toString().equalsIgnoreCase(author)) {
    				foundedBooks.add(bookEntity);
    				break;
    			}
    		}
    	}
        return foundedBooks;
    }

    @Override
    @NullableId
    public BookEntity save(BookEntity book) {
//        if (book.getId() == null) {
//            book.setId(sequence.nextValue(ALL_BOOKS));
//        }
        ALL_BOOKS.add(book);
        return book;
    }
    
    public Sequence getSequence() {
    	return this.sequence;
    }

    private void addTestBooks() {
        ALL_BOOKS.add(new BookEntity(1L, "Romeo i Julia", "1 Wiliam Szekspir"));
        ALL_BOOKS.add(new BookEntity(2L, "Opium w rosole", "2 Hanna Ożogowska"));
        ALL_BOOKS.add(new BookEntity(3L, "Przygody Odyseusza", "3 Jan Parandowski"));
        ALL_BOOKS.add(new BookEntity(4L, "Awantura w Niekłaju", "4 Edmund Niziurski"));
        ALL_BOOKS.add(new BookEntity(5L, "Pan Samochodzik i Fantomas", "5 Zbigniew Nienacki"));
        ALL_BOOKS.add(new BookEntity(6L, "Zemsta", "6 Aleksander Fredro"));
    }
}

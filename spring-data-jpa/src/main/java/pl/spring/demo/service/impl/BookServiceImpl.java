package pl.spring.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

import java.util.List;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    
    @Autowired
    public BookServiceImpl( BookDao bookDao) {
    	this.bookDao = bookDao;
	}
    
    @Override
    @Cacheable("booksCache")
    public List<BookTo> findAllBooks() {
        return BookMapper.map2To(bookDao.findAll());
    }

    @Override
    public List<BookTo> findBooksByTitle(String title) {
        return BookMapper.map2To(bookDao.findBookByTitle(title));
    }

    @Override
    public List<BookTo> findBooksByAuthor(String author) {
        return BookMapper.map2To(bookDao.findBooksByAuthor(author));
    }

    @Override
    public BookTo saveBook(BookTo book) {
    	BookEntity bookEntity = BookMapper.map(book);
    	/* Nie rozumiem dlaczego tu bookEntity jest obiektem, a w metodzie już nie? */
    	bookEntity = bookDao.save(bookEntity);
        return BookMapper.map(bookEntity);
    }
}

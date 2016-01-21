package pl.spring.demo.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
public class BookRestService {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books-by-title", method = RequestMethod.GET)
    public List<BookTo> findBooksByTitle(@RequestParam("titlePrefix") String titlePrefix) {
        return bookService.findBooksByTitle(titlePrefix);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public BookTo addBook(@RequestBody BookTo book) {
        return bookService.saveBook(book);
    }

    @RequestMapping(value = "/book", method = RequestMethod.PUT)
    public BookTo saveBook(@RequestBody BookTo book) {
    	return bookService.saveBook(book);
    }
    
    @RequestMapping(value = "/book", method = RequestMethod.DELETE, produces = "application/json")
    public Map<String, String> deleteBook(@RequestBody BookTo bookTo) {
    	String bookTitle = bookTo.getTitle();
    	bookService.deleteBook(bookTo);
    	return Collections.singletonMap("title", bookTitle );
    }
}

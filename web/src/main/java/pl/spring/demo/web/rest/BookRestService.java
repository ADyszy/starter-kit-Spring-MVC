package pl.spring.demo.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.spring.demo.service.BookService;
import pl.spring.demo.service.UnknownParameterException;
import pl.spring.demo.service.impl.NotExistingBookObjectUpdateException;
import pl.spring.demo.to.BookTo;

import java.util.List;

//@Controller
//@ResponseBody
@RestController // no difference ?
public class BookRestService {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/books-by-title", method = RequestMethod.GET)
	public List<BookTo> findBooksByTitle(@RequestParam("titlePrefix") String titlePrefix) {
		return bookService.findBooksByTitle(titlePrefix);
	}

	@RequestMapping(value = "/book", method = RequestMethod.DELETE)
	public void book(@RequestParam("id") Long bookId) {
		bookService.deleteBook(bookId);
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public BookTo saveBook(@RequestBody BookTo book) {
		return bookService.saveBook(book);
	}

	@RequestMapping(value = "/book", method = RequestMethod.PUT)
	public void book(@RequestParam("id") Long bookId, @RequestParam("paramName") String paramName,
			@RequestParam("value") Object value)
					throws UnknownParameterException, NotExistingBookObjectUpdateException {
		bookService.updateBook(bookId, paramName, value);
	}
}

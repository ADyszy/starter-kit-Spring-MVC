package pl.spring.demo.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.spring.demo.service.BookService;
import pl.spring.demo.service.UnknownParameterException;
import pl.spring.demo.service.impl.NotExistingBookObjectUpdateException;
import pl.spring.demo.to.BookTo;

// To tak roboczo, to samo, co w dopisalem do BookRestService, 
// ale czy dobrze wzdzielic to w taki sposob ?
@RestController
@RequestMapping(value = "/bookCRUD")
public class BookCRUDRest {
	
	@Autowired
	BookService bookService;	
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void book(@RequestParam("id") Long bookId) {
		bookService.deleteBook(bookId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public BookTo saveBook(@RequestBody BookTo book) {
		return bookService.saveBook(book);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void book(@RequestParam("id") Long bookId, @RequestParam("paramName") String paramName,
			@RequestParam("value") Object value)
					throws UnknownParameterException, NotExistingBookObjectUpdateException {
		bookService.updateBook(bookId, paramName, value);
	}
	
}

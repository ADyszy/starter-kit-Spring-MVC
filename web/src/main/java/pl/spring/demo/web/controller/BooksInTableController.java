package pl.spring.demo.web.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@Controller
public class BooksInTableController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/booksInTable", method = RequestMethod.GET)
	public String booksInTable(Map<String, Object> params) {
		final List<BookTo> allBooksInTable = bookService.findAllBooks();
		params.put("books", allBooksInTable);
		return "booksInTable";
	}

	@RequestMapping(value = "/delete-book", method = RequestMethod.POST)
	public String book(Map<String, Object> params, @RequestParam("id") Long bookId) {
		String title = bookService.findTitleByBookId(bookId);
		bookService.deleteBook(bookId);
		params.put("bookTitle", title);
		return "bookDeleted";
	}

	@RequestMapping(value = "/add-book", method = RequestMethod.POST)
	public String book(@RequestParam("authors") String authors,	@RequestParam("title") String title) {
		bookService.saveBook(new BookTo(null, title, authors));
		return "redirect:booksInTable";
	}

	@RequestMapping(value = "/book-adder", method = RequestMethod.POST)
	public String book() {
		return "addBook";
	}

}

package pl.spring.demo.service;

import pl.spring.demo.service.impl.NotExistingBookObjectUpdateException;
import pl.spring.demo.to.BookTo;

import java.util.List;

public interface BookService {

    List<BookTo> findAllBooks();
    List<BookTo> findBooksByTitle(String title);
    List<BookTo> findBooksByAuthor(String author);

    BookTo saveBook(BookTo book);
    void deleteBook(Long bookId);
    //training.
	void updateBook(Long bookId, String paramName, Object value)
			throws UnknownParameterException, NotExistingBookObjectUpdateException;
    
    
	String findTitleByBookId(Long bookId);
}

/**
 * 
 */
package service;

import java.util.List;

import model.Books;

/**
 * @author Lenovo
 *
 */
public interface BookService {
public List<Books> findAllBooks();
	
	public List<Books> searchBooks(String keyword);

	public Books findBookById(Long id);

	public void createBook(Books books);

	public void updateBook(Books books);

	public void deleteBook(Integer id);
}

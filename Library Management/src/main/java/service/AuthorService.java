/**
 * 
 */
package service;

import java.util.List;

import model.Author;

/**
 * @author Lenovo
 *
 */
public interface AuthorService {
	public List<Author> findAllAuthors();

	public Author findAuthorById(Long id);

	public void createAuthor(Author author);

	public void updateAuthor(Author author);

	public void deleteAuthor(Long id);

}

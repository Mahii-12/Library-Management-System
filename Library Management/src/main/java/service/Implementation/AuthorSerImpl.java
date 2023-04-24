/**
 * 
 */
package service.Implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import jakarta.transaction.Transactional;
import model.Author;
import repository.AuthorRepo;
import service.AuthorService;

/**
 * @author Lenovo
 *
 */
@Service
public class AuthorSerImpl implements AuthorService {
   
	private final AuthorRepo authorRepository ;

	public AuthorSerImpl(AuthorRepo authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Author findAuthorById(Long id) {
		return authorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id)));
	}

	@Override
	public void createAuthor(Author author) {
		authorRepository.save(author);
	}

	@Override
	public void updateAuthor(Author author) {
		authorRepository.save(author);
	}

	@Override
	public void deleteAuthor(Long id) {
		final Author author = authorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id)));

		authorRepository.deleteById(author.getId());
	}
	
}

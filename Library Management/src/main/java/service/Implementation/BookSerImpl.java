/**
 * 
 */
package service.Implementation;

import java.awt.print.Book;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.mapping.AccessOptions.SetOptions.Propagation;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import model.Books;
import repository.BookRepo;
import service.BookService;

/**
 * @author Lenovo
 *
 */
@Service
public abstract class BookSerImpl implements BookService{
	
	private final BookRepo bookRepository;
	
	public BookSerImpl(BookRepo bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Books> findAllBooks() {
		return bookRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Books> searchBooks(String keyword) {
		if (keyword != null) {
			return bookRepository.search(keyword);
		}
		return bookRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Books findBookById(Long id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id)));
	}

	@Override
	public void createBook(Books book) {
		bookRepository.save(book);
	}

	@Override
	public void updateBook(Books book) {
		bookRepository.save(book);
	}

	public void deleteBooks(Integer id) {
		final Books book = bookRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id)));

		bookRepository.deleteById(book.getId());
	}

}

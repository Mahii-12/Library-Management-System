/**
 * 
 */
package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Books;

/**
 * @author Lenovo
 *
 */
public interface BookRepo extends JpaRepository<Books,Integer> {

}

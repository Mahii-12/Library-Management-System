/**
 * 
 */
package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Author;

/**
 * @author Lenovo
 *
 */
public interface AuthorRepo extends JpaRepository<Author,Integer>  {

}

/**
 * 
 */
package repository;



import org.springframework.data.jpa.repository.JpaRepository;

import model.Publisher;

/**
 * @author Lenovo
 *
 */
public interface PublisherRepo extends JpaRepository<Publisher,Integer> {

}

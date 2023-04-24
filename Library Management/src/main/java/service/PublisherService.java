/**
 * 
 */
package service;

import java.util.List;

import model.Publisher;

/**
 * @author Lenovo
 *
 */
public interface PublisherService {
	public List<Publisher> findAllPublishers();

	public Publisher findPublisherById(Long id);

	public void createPublisher(Publisher publisher);

	public void updatePublisher(Publisher publisher);

	public void deletePublisher(Integer id);
}

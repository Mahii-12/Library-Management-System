/**
 * 
 */
package model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
/**
 * @author Lenovo
 *
 */
@Getter
@Setter
@Entity
@Table (name =" author")
public class Author<Books> {
	
	  @Column
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;
      
	  @Column (name="name",length=100,nullable=false,unique=true)
      private String Name;
      
	  @Column (name="aboutauthor",length=100,nullable=false,unique=true)
      private String AboutAuthor;
	  
	  private Set<Books> books = new HashSet<Books>();
      
	  
	  
	/**
	 * @return the books
	 */
	public Set<Books> getBooks() {
		return books;
	}



	/**
	 * @param books the books to set
	 */
	public void setBooks(Set<Books> book) {
		this.books = book;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}






	
	  
	  
}

/**
 * 
 */
package model;

import java.awt.print.Book;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lenovo
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="books")
public class Books {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Acc_Id",length=20,nullable=false,unique=true)
	private double Acc_Id;
	
	@Column(name="Name",length=100,nullable=false,unique=true)
	private String Name;
	
    @Column(name="serialName",length=100,nullable=false,unique=true)
    private String serialName;
	
    @Column(name="AboutAuthor",length=100,nullable=false,unique=true)
    private String AboutAuthor;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinTable(name = "books_authors", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "author_id") })
    private Set<Author> authors = new HashSet<Author>();
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "books_department", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "department_id") })
    private Set<Departments> department  = new HashSet<Departments>();
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "books_publishers", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "publisher_id") })
    private Set<Publisher> publishers = new HashSet<Publisher>();

	/**
	 * @param acc_Id
	 * @param name
	 * @param serialName
	 * @param aboutAuthor
	 */
	public Books(double acc_Id, String name, String serialName, String aboutAuthor) {
		super();
		Acc_Id = acc_Id;
		Name = name;
		this.serialName = serialName;
		AboutAuthor = aboutAuthor;
	}
    
	public void addAuthor(Author author) {
		this.authors.add(author);
		author.getBooks().add(this);
	}

	public void removeAuthor(Author author) {
		this.authors.remove(author);
		author.getBooks().remove(this);
	}

	@SuppressWarnings("unchecked")
	public void addDepartments(Departments departments) {
		this.department.add(departments);
		departments.getBooks().addAll((Collection<? extends Book>) this);
	}

	public void removeDepartments(Departments departments) {
		this.department.remove(departments);
		departments.getBooks().remove(this);
	}

	@SuppressWarnings("unchecked")
	public void addPublishers(Publisher publisher) {
		this.publishers.add(publisher);
		publisher.getBooks().addAll((Collection<? extends Book>) this);
	}

	public void removePublishers(Publisher publisher) {
		this.publishers.remove(publisher);
		publisher.getBooks().remove(this);
	}
}

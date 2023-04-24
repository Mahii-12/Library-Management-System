/**
 * 
 */
package service.Implementation;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.mapping.AccessOptions.SetOptions.Propagation;

import jakarta.transaction.Transactional;
import model.Departments;
import repository.DepartmentsRepo;
import service.DepartmentService;

/**
 * @author Lenovo
 *
 */
public abstract class DepartmentsSerImpl implements DepartmentService{
	private final DepartmentsRepo departmentsRepository ;
	
	public DepartmentsSerImpl(DepartmentsRepo departmentsRepository) {
		this.departmentsRepository = departmentsRepository;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Departments> findAllDepartments() {
		return departmentsRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Departments findDepartmentsById(Long id) {
		return departmentsRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Category not found  with ID %d", id)));
	}

	@Override
	public void createDepartments(Departments departments) {
		departmentsRepository.save(departments);
	}

	@Override
	public void updateDepartments(Departments departments) {
		departmentsRepository.save(departments);
	}

	@Override
	public void deleteDepartments(integer id) {
		final Departments departments = departmentsRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Category not found  with ID %d", id)));

		departmentsRepository.deleteById(departments.getId());
	}
}

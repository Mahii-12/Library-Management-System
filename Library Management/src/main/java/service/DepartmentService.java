/**
 * 
 */
package service;

import java.util.List;

import model.Departments;

/**
 * @author Lenovo
 *
 */
public interface DepartmentService {
	public List<Departments> findAllDepartments();

	public Departments findDepartmentsById(Long id);

	public void createDepartments(Departments departments);

	public void updateDepartments(Departments departments);

	public void deleteDepartments(Integer id);
}

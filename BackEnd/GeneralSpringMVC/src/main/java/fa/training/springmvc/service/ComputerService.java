/**
 * @author HauHP
 * @date 24 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.springmvc.entities.Computer;

public interface ComputerService {
	Computer getComputerByCode(String maMay);

	void save(Computer computer);

	void update(Computer computer);

	List<Computer> getList();

	List<Computer> findByName(String name);

	void delete(String maMay);

	boolean isComputerCodeExist(String maMay);

	Page<Computer> findAll(Pageable pageable);

	Page<Computer> findByNamePage(String name, Pageable pageable);
}

/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.repository;

import java.util.List;

import modal.bean.Computer;

public interface ComputerRepository {
	Computer getComputerByCode(String maMay);

	void save(Computer computer);

	void update(Computer computer);

	List<Computer> getList();

	void delete(String maMay);

}

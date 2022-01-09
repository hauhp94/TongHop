/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.repository;

import java.util.List;

import modal.bean.RegisterComputer;

public interface RegisterComputerRepository {
	void save(RegisterComputer registerComputer);

	List<RegisterComputer> getList();

}

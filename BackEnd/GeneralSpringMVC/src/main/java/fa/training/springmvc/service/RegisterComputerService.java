/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.service;

import java.util.List;

import fa.training.springmvc.entities.RegisterComputer;

public interface RegisterComputerService {
	void save(RegisterComputer registerComputer);

	List<RegisterComputer> getList();
}

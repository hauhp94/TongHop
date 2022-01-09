/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.service;

import java.util.List;

import modal.bean.RegisterComputer;

public interface RegisterComputerService {
	void save(RegisterComputer registerComputer);

	List<RegisterComputer> getList();
}

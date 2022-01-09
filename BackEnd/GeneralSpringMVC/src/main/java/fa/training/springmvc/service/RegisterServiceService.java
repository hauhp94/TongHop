/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.service;

import java.util.List;

import fa.training.springmvc.entities.RegisterService;

public interface RegisterServiceService {
	void save(RegisterService registerService);

	List<RegisterService> getList();
}

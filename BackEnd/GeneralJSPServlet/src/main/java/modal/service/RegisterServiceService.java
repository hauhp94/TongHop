/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.service;

import java.util.List;

import modal.bean.RegisterService;

public interface RegisterServiceService {
	void save(RegisterService registerService);

	List<RegisterService> getList();
}

/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.service;

import java.util.List;

import modal.bean.RegisterService;
import modal.repository.RegisterServiceRepository;
import modal.repository.RegisterServiceRepositoryImpl;

public class RegisterServiceServiceImpl implements RegisterServiceService {
	RegisterServiceRepository registerServiceRepository = new RegisterServiceRepositoryImpl();

	@Override
	public void save(RegisterService registerService) {
		registerServiceRepository.save(registerService);
	}

	@Override
	public List<RegisterService> getList() {
		return registerServiceRepository.getList();
	}

}

/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.service;

import java.util.List;

import modal.bean.RegisterComputer;
import modal.repository.RegisterComputerRepository;
import modal.repository.RegisterComputerRepositoryImpl;

public class RegisterComputerServiceImpl implements RegisterComputerService {
	RegisterComputerRepository registerComputerRepository = new RegisterComputerRepositoryImpl();

	@Override
	public void save(RegisterComputer registerComputer) {
		registerComputerRepository.save(registerComputer);
	}

	@Override
	public List<RegisterComputer> getList() {
		return registerComputerRepository.getList();
	}

}

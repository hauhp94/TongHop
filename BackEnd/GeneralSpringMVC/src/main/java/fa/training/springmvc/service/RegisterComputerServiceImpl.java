/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.springmvc.entities.RegisterComputer;
import fa.training.springmvc.repository.RegisterComputerRepository;
@Service

public class RegisterComputerServiceImpl implements RegisterComputerService {
	@Autowired
	RegisterComputerRepository registerComputerRepository;

	@Override
	public void save(RegisterComputer registerComputer) {
		
		registerComputerRepository.save(registerComputer);
	}

	@Override
	public List<RegisterComputer> getList() {
		return registerComputerRepository.findAll();
	}

}

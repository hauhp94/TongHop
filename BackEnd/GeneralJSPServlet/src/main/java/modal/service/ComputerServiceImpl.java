/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.service;

import java.util.List;

import modal.bean.Computer;
import modal.repository.ComputerReposirotyImpl;
import modal.repository.ComputerRepository;

public class ComputerServiceImpl implements ComputerService{
	ComputerRepository computerRepository = new ComputerReposirotyImpl();

	@Override
	public Computer getComputerByCode(String maMay) {
		return computerRepository.getComputerByCode(maMay);
	}

	@Override
	public void save(Computer computer) {
		computerRepository.save(computer);
		
	}

	@Override
	public void update(Computer computer) {
		computerRepository.update(computer);
		
	}

	@Override
	public List<Computer> getList() {
		return computerRepository.getList();
	}

	@Override
	public void delete(String maMay) {
		computerRepository.delete(maMay);
		
	}

}

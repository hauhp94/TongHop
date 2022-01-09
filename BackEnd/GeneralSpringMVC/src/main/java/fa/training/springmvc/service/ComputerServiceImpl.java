/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.springmvc.entities.Computer;
import fa.training.springmvc.repository.ComputerRepository;

@Service
public class ComputerServiceImpl implements ComputerService{
	@Autowired
	private ComputerRepository computerRepository;

	@Override
	public Computer getComputerByCode(String maMay) {
		return computerRepository.findById(maMay).get();
	}

	@Override
	public void save(Computer computer) {
		computerRepository.save(computer);
		
	}

	@Override
	public void update(Computer computer) {
		computerRepository.save(computer);
		
	}

	@Override
	public List<Computer> getList() {
		return computerRepository.findAll();
	}

	@Override
	public void delete(String maMay) {
		computerRepository.deleteById(maMay);
		
	}

	@Override
	public boolean isComputerCodeExist(String maMay) {
		return computerRepository.existsById(maMay);
	}

	@Override
	public Page<Computer> findAll(Pageable pageable) {
		return computerRepository.findAll(pageable);
	}

	@Override
	public Page<Computer> findByNamePage(String name, Pageable pageable) {
		return computerRepository.findByNamePage(name, pageable);
	}

	@Override
	public List<Computer> findByName(String name) {
		return computerRepository.findByName(name);
	}

}

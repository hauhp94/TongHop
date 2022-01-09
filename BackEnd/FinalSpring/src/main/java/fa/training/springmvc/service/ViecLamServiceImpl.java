/**
 * @author HauHP
 * @date 6 thg 1, 2022
 * @version 1.0
 */
package fa.training.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.springmvc.entities.ViecLam;
import fa.training.springmvc.repository.ViecLamRepository;

@Service
public class ViecLamServiceImpl implements ViecLamService {
	@Autowired
	private ViecLamRepository viecLamRepository;

	@Override
	public List<ViecLam> findAll() {
		return viecLamRepository.findAllCustome();
	}

	@Override
	public List<ViecLam> findByName(String name) {
		return viecLamRepository.findByName(name);
	}

	@Override
	public Page<ViecLam> findAll(Pageable pageable) {
		return viecLamRepository.findAllCustome(pageable);
	}
	
	@Override
	public Page<ViecLam> findByNamePage(String name, Pageable pageable) {
		return viecLamRepository.findByNamePage(name, pageable);
	}

	@Override
	public ViecLam findById(String maVL) {
		return viecLamRepository.findById(maVL).get();
	}

	@Override
	public void save(ViecLam viecLam) {
		viecLamRepository.save(viecLam);

	}

	@Override
	public void update(ViecLam viecLam) {
		viecLamRepository.save(viecLam);
	}

	@Override
	public void delete(String maVL) {
		viecLamRepository.deleteById(maVL);

	}

	@Override
	public boolean isIdExist(String id) {
		return viecLamRepository.existsById(id);

	}

}

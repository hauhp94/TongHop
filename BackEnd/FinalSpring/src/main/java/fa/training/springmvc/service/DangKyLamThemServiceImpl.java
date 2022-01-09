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

import fa.training.springmvc.entities.DangKyLamThem;
import fa.training.springmvc.repository.DangKyLamThemRepository;

@Service
public class DangKyLamThemServiceImpl implements DangKyLamThemService{
	@Autowired
	private DangKyLamThemRepository dangKyLamThemRepository;

	@Override
	public List<DangKyLamThem> findAll() {
		return dangKyLamThemRepository.findAll();
	}

	@Override
	public List<DangKyLamThem> findByName(String name) {
		return dangKyLamThemRepository.findByName(name);
	}

	@Override
	public Page<DangKyLamThem> findAll(Pageable pageable) {
		return dangKyLamThemRepository.findAll(pageable);
	}

	@Override
	public Page<DangKyLamThem> findByNamePage(String name, Pageable pageable) {
		return dangKyLamThemRepository.findByNamePage(name, pageable);
	}

	@Override
	public DangKyLamThem findById(String maVL) {
		return dangKyLamThemRepository.findById(maVL).get();
	}

	@Override
	public void save(DangKyLamThem dangKyLamThem) {
		dangKyLamThemRepository.save(dangKyLamThem);	
	}

	@Override
	public void update(DangKyLamThem dangKyLamThem) {
		dangKyLamThemRepository.save(dangKyLamThem);			
	}

	@Override
	public void delete(String maDK) {
		dangKyLamThemRepository.deleteById(maDK);
	}
	
	@Override
	public boolean isIdExist(String id) {
		return dangKyLamThemRepository.existsById(id);
	}

}

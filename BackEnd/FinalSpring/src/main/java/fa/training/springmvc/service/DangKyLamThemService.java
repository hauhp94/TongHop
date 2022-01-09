/**
 * @author HauHP
 * @date 6 thg 1, 2022
 * @version 1.0
 */
package fa.training.springmvc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.springmvc.entities.DangKyLamThem;

public interface DangKyLamThemService {
	List<DangKyLamThem> findAll();

	List<DangKyLamThem> findByName(String name);

	Page<DangKyLamThem> findAll(Pageable pageable);

	Page<DangKyLamThem> findByNamePage(String name, Pageable pageable);

	DangKyLamThem findById(String maVL);

	void save(DangKyLamThem dangKyLamThem);

	void update(DangKyLamThem dangKyLamThem);

	void delete(String maDK);

	boolean isIdExist(String id);
}

/**
 * @author HauHP
 * @date 6 thg 1, 2022
 * @version 1.0
 */
package fa.training.springmvc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.springmvc.entities.ViecLam;


public interface ViecLamService {
	List<ViecLam> findAll();

	List<ViecLam> findByName(String name);

	Page<ViecLam> findAll(Pageable pageable);

	Page<ViecLam> findByNamePage(String name, Pageable pageable);

	ViecLam findById(String maVL);

	void save(ViecLam viecLam);

	void update(ViecLam viecLam);

	void delete(String maVL);

	boolean isIdExist(String id);
	
}

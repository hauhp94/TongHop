/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.springmvc.entities.Service;

public interface ServiceService {
	Service getServiceByCode(String maDV);

	void save(Service service);

	void update(Service service);

	List<Service> getList();

	void delete(String maDV);
	
	boolean isServiceCodeExist(String maDV);
	
	Page<Service> findAll(Pageable pageable);

	Page<Service> findByNamePage(String name, Pageable pageable);
	List<Service> findByName(String name);


}

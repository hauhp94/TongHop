/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.springmvc.entities.Customer;

public interface CustomerService {
	Page<Customer> findAll(Pageable pageable);

	Page<Customer> findByNamePage(String name, Pageable pageable);

	List<Customer> getList();

	List<Customer> findByName(String name);

	Customer getCustomerByCode(String maKH);

	void save(Customer customer);

	void update(Customer customer);

	void delete(String maKH);

	boolean isCustomerCodeExist(String maKH);

}

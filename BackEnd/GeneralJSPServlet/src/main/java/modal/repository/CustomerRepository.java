/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.repository;

import java.util.List;

import modal.bean.Customer;

public interface CustomerRepository {
	Customer getCustomerByCode(String maKH);

	void save(Customer customer);

	void update(Customer customer);

	List<Customer> getList();

	void delete(String maKH);

	List<Customer> findByName(String name);
	
	boolean isCustomerCodeExist(String maKH);

}

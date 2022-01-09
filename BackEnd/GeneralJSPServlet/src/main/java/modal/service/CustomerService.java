/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.service;

import java.util.List;
import java.util.Map;

import modal.bean.Customer;

public interface CustomerService {
	Customer getCustomerByCode(String maKH);

	Map<String, String> save(Customer customer);

	void update(Customer customer);

	List<Customer> getList();

	void delete(String maKH);

	List<Customer> findByName(String name);

	boolean isCustomerCodeExist(String maKH);

}

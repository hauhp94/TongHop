/**
 * @author HauHP
 * @date 28 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.service;

import java.util.List;
import java.util.Map;

import fa.training.springmvc.entities.Customer;
import fa.training.springmvc.entities.CustomerUsing;

public interface CustomerUsingService {
	public List<CustomerUsing> getList();
	
	public List<Customer> getListCustomer();

	public Map<String, String> totalMoneyMap();
}

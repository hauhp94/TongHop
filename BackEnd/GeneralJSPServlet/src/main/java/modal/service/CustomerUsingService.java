/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.service;

import java.util.List;

import modal.bean.CustomerUsing;
import modal.repository.CustomerUsingRepository;
import modal.repository.CustomerUsingRepositoryImpl;

public class CustomerUsingService {
	CustomerUsingRepository customerUsingRepository = new CustomerUsingRepositoryImpl();
	public List<CustomerUsing> getList() {
		return customerUsingRepository.getList();
	}

}

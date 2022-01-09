/**
 * @author HauHP
 * @date 28 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.springmvc.entities.Customer;
import fa.training.springmvc.entities.CustomerUsing;
import fa.training.springmvc.entities.TotalMoney;
import fa.training.springmvc.repository.CustomerUsingRepository;

@Service
public class CustomerUsingServiceImpl implements CustomerUsingService {
	@Autowired
	private CustomerUsingRepository customerUsingRepository;

	@Override
	public List<CustomerUsing> getList() {
		return customerUsingRepository.getList();
	}

	@Override
	public Map<String, String> totalMoneyMap() {
		Map<String, String> map = new HashMap<String, String>();
		List<TotalMoney> totList = customerUsingRepository.getTotalMoney();
		for (TotalMoney totalMoney : totList) {
			map.put(totalMoney.getMaKH(), totalMoney.getTongTien());
		}
		return map;
	}

	@Override
	public List<Customer> getListCustomer() {
		// TODO Auto-generated method stub
		return customerUsingRepository.findAll();
	}

}

/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modal.bean.Customer;
import modal.repository.CustomerRepository;
import modal.repository.CustomerRepositoryImpl;
import modal.service.validate.Validate;

public class CustomerServiceImpl implements CustomerService {
	CustomerRepository customerRepository = new CustomerRepositoryImpl();

	@Override
	public Customer getCustomerByCode(String maKH) {
		return customerRepository.getCustomerByCode(maKH);
	}

	@Override
	public Map<String,String> save(Customer customer) {
		 Map<String, String> mapMessage = new HashMap<>();
	        if (Validate.validateMaKH(customer.getMaKH()) != null||
	        		Validate.validatePhoneNumber(customer.getSoDienThoai()) != null||
	        		Validate.validateEmail(customer.getEmail()) != null|| isCustomerCodeExist(customer.getMaKH())) {
	            mapMessage.put("maKH", Validate.validateMaKH(customer.getMaKH()));
	            mapMessage.put("soDienThoai", Validate.validatePhoneNumber(customer.getSoDienThoai()));
	            mapMessage.put("email", Validate.validateEmail(customer.getEmail()));
	            mapMessage.put("maKHTonTai",Validate.validateCodeExist(customer.getMaKH()));
	        } else {
	    		customerRepository.save(customer);
	        }
//	        if (Validate.validatePhoneNumber(employee.getEmployee_phone()) != null
//	        		|| Validate.validateIdCard(employee.getEmployee_id_card()) != null
//	        		|| Validate.validatePositiveNumbers(employee.getEmployee_salary()) != null
//	        		|| Validate.validateEmail(employee.getEmployee_email()) != null) {
//	        	mapMessage.put("phone", Validate.validatePhoneNumber(employee.getEmployee_phone()));
//	        	mapMessage.put("idCard", Validate.validateIdCard(employee.getEmployee_id_card()));
//	        	mapMessage.put("salary",Validate.validatePositiveNumbers(employee.getEmployee_salary()));
//	        	mapMessage.put("email", Validate.validateEmail(employee.getEmployee_email()));
//	        } else {
//	        	customerRepository.save(customer);
//	        }
	        return mapMessage;

	}

	@Override
	public void update(Customer customer) {
		customerRepository.update(customer);

	}

	@Override
	public List<Customer> getList() {
		return customerRepository.getList();
	}

	@Override
	public void delete(String maKH) {
		customerRepository.delete(maKH);

	}

	@Override
	public List<Customer> findByName(String name) {
		return customerRepository.findByName(name);
	}

	@Override
	public boolean isCustomerCodeExist(String maKH) {
		return customerRepository.isCustomerCodeExist(maKH);
	}

}

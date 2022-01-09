/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.springmvc.entities.Customer;
import fa.training.springmvc.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer getCustomerByCode(String maKH) {
		return customerRepository.findById(maKH).get();
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);

	}

	@Override
	public void update(Customer customer) {
		customerRepository.save(customer);

	}

	@Override
	public List<Customer> getList() {
		return customerRepository.findAll();
	}

	@Override
	public void delete(String maKH) {
		customerRepository.deleteById(maKH);

	}

	@Override
	public List<Customer> findByName(String name) {
		return customerRepository.findByName(name);
	}

	@Override
	public boolean isCustomerCodeExist(String maKH) {
		return customerRepository.existsById(maKH);
	}

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}

	@Override
	public Page<Customer> findByNamePage(String name, Pageable pageable) {
		return customerRepository.findByNamePage(name, pageable);
	}

}

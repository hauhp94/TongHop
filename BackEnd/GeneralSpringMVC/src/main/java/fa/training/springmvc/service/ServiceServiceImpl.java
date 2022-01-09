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

import fa.training.springmvc.entities.Service;
import fa.training.springmvc.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
	@Autowired
	ServiceRepository serviceRepository;

	@Override
	public Service getServiceByCode(String maDV) {
		return serviceRepository.findById(maDV).get();
	}

	@Override
	public void save(Service service) {
		serviceRepository.save(service);
	}

	@Override
	public void update(Service service) {
		serviceRepository.save(service);
	}

	@Override
	public List<Service> getList() {
		return serviceRepository.findAll();
	}

	@Override
	public void delete(String maDV) {
		serviceRepository.deleteById(maDV);
	}

	@Override
	public boolean isServiceCodeExist(String maDV) {
		return serviceRepository.existsById(maDV);
	}

	@Override
	public Page<Service> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return serviceRepository.findAll(pageable);
	}

	@Override
	public Page<Service> findByNamePage(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return serviceRepository.findByNamePage(name, pageable);
	}

	@Override
	public List<Service> findByName(String name) {
		// TODO Auto-generated method stub
		return serviceRepository.findByName(name);
	}

}

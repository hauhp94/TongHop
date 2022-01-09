/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.service;

import java.util.List;

import modal.bean.Service;
import modal.repository.ServiceRepository;
import modal.repository.ServiceRepositoryImpl;

public class ServiceServiceImpl implements ServiceService {
	ServiceRepository serviceRepository = new ServiceRepositoryImpl();

	@Override
	public Service getServiceByCode(String maDV) {
		return serviceRepository.getServiceByCode(maDV);
	}

	@Override
	public void save(Service service) {
		serviceRepository.save(service);
	}

	@Override
	public void update(Service service) {
		serviceRepository.update(service);

	}

	@Override
	public List<Service> getList() {
		return serviceRepository.getList();
	}

	@Override
	public void delete(String maDV) {
		serviceRepository.delete(maDV);

	}

}

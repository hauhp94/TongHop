/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package modal.repository;

import java.util.List;

import modal.bean.Service;

public interface ServiceRepository {
	Service getServiceByCode(String maDV);

	void save(Service service);

	void update(Service service);

	List<Service> getList();

	void delete(String maDV);

}

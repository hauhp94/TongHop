package connection;

import java.util.List;

import entity.Phone;

interface PhoneRepository {
	List<Phone> findAll();

	void savePhone(Phone phone);

	void updatePhone(Phone phone);
	
	List<Phone> searchByPrice(double minPrice, double maxPrice);

	void deletePhone(String id);
}

/**
 * @author HauHP
 * @date 23 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.springmvc.entities.RegisterService;
import fa.training.springmvc.repository.RegisterServiceRepository;
@Service

public class RegisterServiceServiceImpl implements RegisterServiceService {
	@Autowired
	RegisterServiceRepository registerServiceRepository;

	@Override
	public void save(RegisterService registerService) {
//			LocalDate localDate = LocalDate.parse(registerService.getNgaySuDung());
//	
//	        registerService.setNgaySuDung(localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
		registerServiceRepository.save(registerService);
	}

	@Override
	public List<RegisterService> getList() {
		return registerServiceRepository.findAll();
	}

}

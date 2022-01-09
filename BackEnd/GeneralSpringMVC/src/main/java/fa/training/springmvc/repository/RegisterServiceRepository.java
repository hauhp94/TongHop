/**
 * @author HauHP
 * @date 24 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.springmvc.entities.RegisterService;

@Repository
public interface RegisterServiceRepository extends JpaRepository<RegisterService, String> {

}

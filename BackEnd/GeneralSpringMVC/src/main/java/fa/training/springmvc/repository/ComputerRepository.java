/**
 * @author HauHP
 * @date 24 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.training.springmvc.entities.Computer;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, String> {
	
	@Query(value = "SELECT * FROM dbo.Computer WHERE concat(maMay,viTri,trangThai) LIKE concat('%',:keyword,'%')", nativeQuery = true)
	List<Computer> findByName(@Param("keyword") String keyword);

	@Query(value = "SELECT * FROM dbo.Computer WHERE concat(maMay,viTri,trangThai) LIKE concat('%',:keyword,'%')", nativeQuery = true)
	Page<Computer> findByNamePage(@Param("keyword") String keyword, Pageable pageable);

}

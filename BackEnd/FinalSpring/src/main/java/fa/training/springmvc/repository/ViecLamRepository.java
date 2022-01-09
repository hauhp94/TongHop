/**
 * @author HauHP
 * @date 6 thg 1, 2022
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

import fa.training.springmvc.entities.ViecLam;
@Repository
public interface ViecLamRepository extends JpaRepository<ViecLam, String>{
	@Query(value = "SELECT * FROM dbo.ViecLam WHERE concat(ngonNgu,duAn) LIKE concat('%',:keyword,'%') AND trangThai NOT LIKE CONCAT('%','Closed','%') AND trangThai NOT LIKE CONCAT('%','Hired','%')", nativeQuery = true)
	List<ViecLam> findByName(@Param("keyword") String keyword);

	@Query(value = "SELECT * FROM dbo.ViecLam WHERE concat(ngonNgu,duAn) LIKE concat('%',:keyword,'%') AND trangThai NOT LIKE CONCAT('%','Closed','%') AND trangThai NOT LIKE CONCAT('%','Hired','%')", nativeQuery = true)
	Page<ViecLam> findByNamePage(@Param("keyword") String keyword, Pageable pageable);
	
	@Query(value = "SELECT * FROM dbo.ViecLam WHERE trangThai NOT LIKE CONCAT('%','Closed','%') AND trangThai NOT LIKE CONCAT('%','Hired','%')", nativeQuery = true)
	List<ViecLam> findAllCustome();
	
	@Query(value = "SELECT * FROM dbo.ViecLam WHERE trangThai NOT LIKE CONCAT('%','Closed','%') AND trangThai NOT LIKE CONCAT('%','Hired','%')", nativeQuery = true)
	Page<ViecLam> findAllCustome(Pageable pageable);


}

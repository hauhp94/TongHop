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

import fa.training.springmvc.entities.DangKyLamThem;
@Repository
public interface DangKyLamThemRepository extends JpaRepository<DangKyLamThem, String> {
	@Query(value = "SELECT * FROM dbo.DangKyLamThem WHERE concat(maNV,hoTen) LIKE concat('%',:keyword,'%')", nativeQuery = true)
	List<DangKyLamThem> findByName(@Param("keyword") String keyword);

	@Query(value = "SELECT * FROM dbo.DangKyLamThem WHERE concat(maNV,hoTen) LIKE concat('%',:keyword,'%')", nativeQuery = true)
	Page<DangKyLamThem> findByNamePage(@Param("keyword") String keyword, Pageable pageable);
}

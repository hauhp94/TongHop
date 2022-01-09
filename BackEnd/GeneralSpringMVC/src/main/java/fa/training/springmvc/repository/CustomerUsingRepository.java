/**
 * @author HauHP
 * @date 28 thg 12, 2021
 * @version 1.0
 */
package fa.training.springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fa.training.springmvc.entities.Customer;
import fa.training.springmvc.entities.CustomerUsing;
import fa.training.springmvc.entities.TotalMoney;

@Repository
public interface CustomerUsingRepository extends JpaRepository<Customer, String> {
	@Query(nativeQuery = true, value = "SELECT dbo.Customer.maKH,tenKH,computer.maMay, viTri,trangThai,ngayBatDauSuDung,gioBatDauSuDung,thoiGianSuDung,\r\n"
			+ "service.maDV,ngaySuDung,gioSuDung,soLuong\r\n"
			+ "		FROM dbo.Customer \r\n"
			+ "LEFT JOIN dbo.RegisterComputer ON RegisterComputer.maKH = Customer.maKH \r\n"
			+ "LEFT JOIN dbo.Computer ON Computer.maMay = RegisterComputer.maMay \r\n"
			+ "LEFT JOIN dbo.RegisterService ON RegisterService.maKH = Customer.maKH \r\n"
			+ "LEFT JOIN dbo.Service ON Service.maDV = RegisterService.maDV")
	public List<CustomerUsing> getList();
	

	@Query(nativeQuery = true, value = "SELECT dbo.Customer.maKH, SUM(donGia * soLuong) AS tongTien FROM dbo.Customer\r\n"
			+ "LEFT JOIN dbo.RegisterService ON dbo.RegisterService.maKH = dbo.Customer.maKH\r\n"
			+ "JOIN dbo.Service ON dbo.Service.maDV = dbo.RegisterService.maDV\r\n"
			 + " GROUP BY dbo.Customer.maKH")
	public List<TotalMoney> getTotalMoney();

}

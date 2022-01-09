package fa.training.springmvc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.springmvc.entities.ProductEntity;

@Repository
public class ProductRepository {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<ProductEntity> getProducts() {
		Session session = sessionFactory.openSession();
		List<ProductEntity> list = session.createQuery("Select p from ProductEntity p", ProductEntity.class)
				.getResultList();
		return list;
	}
	
	@Transactional
	public void addProduct(ProductEntity product) {
		Session session = sessionFactory.openSession();
		session.save(product);
	}
	
	@Transactional
	public ProductEntity getProduct(int prdId) {
		Session session = sessionFactory.openSession();
		ProductEntity product = session.find(ProductEntity.class, prdId);
		return product;
	}
	
	@Transactional
	public void updateProduct(ProductEntity product) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
	}
}

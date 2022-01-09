package fa.training.springmvc.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.springmvc.entities.ProductEntity;
import fa.training.springmvc.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Transactional
	public List<ProductEntity> getProducts() {
		return productRepository.getProducts();
	}
	
	@Transactional
	public void addProduct(ProductEntity product) {
		productRepository.addProduct(product);
	}
	
	@Transactional
	public ProductEntity getProduct(int prdId) {
		return productRepository.getProduct(prdId);
	}
	
	@Transactional
	public void updateProduct(ProductEntity product) {
		productRepository.updateProduct(product);
	}
}

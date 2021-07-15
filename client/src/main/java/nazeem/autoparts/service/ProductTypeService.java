package nazeem.autoparts.service;

import nazeem.autoparts.model.ProductType;
import nazeem.autoparts.repository.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductTypeService {

    @Autowired
    private IProductTypeRepository repo;

    public List<ProductType> listAll() {
        return (List<ProductType>) repo.findAll();
    }

    public void save(ProductType product) {
        repo.save(product);
    }

    public ProductType get(long  id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
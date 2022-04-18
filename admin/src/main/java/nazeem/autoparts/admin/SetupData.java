package nazeem.autoparts.admin;

/*
    Created By: noman azeem
    Contact: syed.noman.azeem@gmail.com
*/
import nazeem.autoparts.library.model.*;
import nazeem.autoparts.library.model.customer.Country;
import nazeem.autoparts.library.model.product.Category;
import nazeem.autoparts.library.model.product.Make;
import nazeem.autoparts.library.model.product.Model;
import nazeem.autoparts.library.model.user.Role;
import nazeem.autoparts.library.repository.*;
import nazeem.autoparts.library.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SetupData implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private MakeRepository makeRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup)
            return;

        //Setup roles
        createRoleIfNotFound("ADMIN");
        createRoleIfNotFound("CUSTOMER");

        //Setup categories
        createCategoryIfNotFound(new Category("Laptop","Laptop"));
        createCategoryIfNotFound(new Category("Phone", "Phone"));
        createCategoryIfNotFound(new Category("Pc", "Pc"));
        createCategoryIfNotFound(new Category("Phụ kiện","Phụ Kiện"));
        
        //Setup Countries
        createCountryIfNotFound(new Country("VN", "VietName"));
        createCountryIfNotFound(new Country("RU", "Russia"));
        createCountryIfNotFound(new Country("UK", "United Kingdom"));
        createCountryIfNotFound(new Country("INDO", "Indonesia"));
        createCountryIfNotFound(new Country("CHI", "China"));

        //Setup Make
//        Make Laptop = createMakeIfNotFound(new Make("Laptop"));
//
//        Make Phone = createMakeIfNotFound(new Make("Phone"));
//
//        Make PC = createMakeIfNotFound(new Make("PC"));
//
//        Make gmc = createMakeIfNotFound(new Make("GMC"));
//
//        Make honda = createMakeIfNotFound(new Make("Honda"));
//
//        Make kawasaky = createMakeIfNotFound(new Make("Kawasaky"));
//
//        Make lexus = createMakeIfNotFound(new Make("Lexus"));
//
//        Make mazda = createMakeIfNotFound(new Make("Mazda"));
//
//        Make mercedes = createMakeIfNotFound(new Make("Mercedes"));
//
//        Make toyota = createMakeIfNotFound(new Make("Toyota"));
//
//        Make yamaha = createMakeIfNotFound(new Make("Yamaha"));

        //Setup model
//        createModelIfNotFound(new Model("Macbook 2015", Laptop));
//        createModelIfNotFound(new Model("Macbook 2016", Laptop));
//        createModelIfNotFound(new Model("Macbook 2017", Laptop));
//        createModelIfNotFound(new Model("Macbook 2018", Laptop));
//        createModelIfNotFound(new Model("Macbook 2019", Laptop));
//
//
//        createModelIfNotFound(new Model("Samsung Galaxy S7", Phone));
//        createModelIfNotFound(new Model("Samsung Galaxy A7", Phone));
//        createModelIfNotFound(new Model("Samsung Galaxy A8", Phone));
//        createModelIfNotFound(new Model("Samsung Galaxy Note8", Phone));
//        createModelIfNotFound(new Model("Samsung Galaxy 10 Plus", Phone));
//        
//        createModelIfNotFound(new Model("Asus Gamming", PC));

//        createModelIfNotFound(new Model("Excel Model", bmw));
//        createModelIfNotFound(new Model("2D Model", bmw));
//        createModelIfNotFound(new Model("3 Series", bmw));
//
//        createModelIfNotFound(new Model("4D Model", gmc));
//
//        createModelIfNotFound(new Model("2D Model", honda));
//        createModelIfNotFound(new Model("3D Model", honda));
//        createModelIfNotFound(new Model("Excel Model", honda));
//
//        createModelIfNotFound(new Model("2D Model", kawasaky));
//
//        createModelIfNotFound(new Model("3D Model", lexus));
//
//        createModelIfNotFound(new Model("2D Model", mazda));
//        createModelIfNotFound(new Model("3D Model", mazda));
//
//        createModelIfNotFound(new Model("3D Model", mercedes));
//        createModelIfNotFound(new Model("4D Model", mercedes));
//
//        createModelIfNotFound(new Model("2D Model", toyota));
//        createModelIfNotFound(new Model("3D Model", toyota));
//        createModelIfNotFound(new Model("4D Model", toyota));
//        createModelIfNotFound(new Model("Excel Model", toyota));
//
//        createModelIfNotFound(new Model("3D Model", yamaha));
    }

    @Transactional
    Role createRoleIfNotFound(String name) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            roleRepository.save(role);

            //return saved object
            role = roleRepository.findByName(name);
        }
        return role;
    }

    @Transactional
    Category createCategoryIfNotFound(Category category) {
        Category category1 = categoryRepository.findByName(category.getName());
        if (category1 == null) {
            categoryRepository.save(category);

            //return saved object
            category1 = categoryRepository.findByName(category.getName());
        }
        return category1;
    }

    @Transactional
    Country createCountryIfNotFound(Country country) {
        Country country1 = countryRepository.findByName(country.getName());
        if (country1 == null) {
            countryRepository.save(country);

            //return saved object
            country1 = countryRepository.findByName(country.getName());
        }
        return country1;
    }

//    @Transactional
//    Make createMakeIfNotFound(Make make) {
//        Make make1 = makeRepository.findByName(make.getName());
//        if (make1 == null) {
//            makeRepository.save(make);
//            //return saved object
//            make1 = makeRepository.findByName(make.getName());
//        }
//
//        return make1;
//    }

//    @Transactional
//    Model createModelIfNotFound(Model model) {
//        Model model1 = modelRepository.findByName2(model.getName(), model.getMake().getId());
//        if (model1 == null) {
//            modelRepository.save(model);
//
//            //return saved object
//            model1 = modelRepository.findByName2(model.getName(), model.getMake().getId());
//        }
//        return model1;
//    }
}

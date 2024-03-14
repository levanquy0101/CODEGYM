package m4.product.controller;

import m4.product.model.Product;
import m4.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String home(Model model, @RequestParam(required = false) String q) {
        List<Product> products = q != null ? productService.search(q) : productService.findAll();
        model.addAttribute("products", products);

        return "home";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("product", new Product());

        return "form";
    }

    @GetMapping("{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Optional<Product> opProduct = productService.getById(id);
        if (opProduct.isPresent()) {
            model.addAttribute("product", opProduct.get());
        }

        return "form";
    }

    @PostMapping
    public String save(Product product) {
        productService.save(product);

        return "redirect:/products";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id) {
        productService.delete(id);

        return "redirect:/products";
    }
}

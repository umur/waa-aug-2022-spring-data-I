package lab3.phase.controller;

import lab3.phase.dto.ProductDTO;
import lab3.phase.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private IProductService serv;

    @Autowired
    public ProductController(IProductService serv) {
        this.serv = serv;
    }

    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO item) {
        return serv.createOrUpdate(item);
    }

    @GetMapping
    public List<ProductDTO> read() {
        return serv.read();
    }

    @PutMapping
    public ProductDTO update(@RequestBody ProductDTO item) {
        if (item.getId() == 0)
            return null;
        return serv.createOrUpdate(item);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable int id) {
        return serv.delete(id);
    }
}

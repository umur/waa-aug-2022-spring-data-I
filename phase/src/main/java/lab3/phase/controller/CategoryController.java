package lab3.phase.controller;

import lab3.phase.dto.AddressDTO;
import lab3.phase.dto.CategoryDTO;
import lab3.phase.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private ICategoryService serv;

    @Autowired
    public CategoryController(ICategoryService serv) {
        this.serv = serv;
    }

    @PostMapping
    public CategoryDTO create(@RequestBody CategoryDTO item) {
        return serv.createOrUpdate(item);
    }

    @GetMapping
    public List<CategoryDTO> read() {
        return serv.read();
    }

    @PutMapping
    public CategoryDTO update(@RequestBody CategoryDTO item) {
        if (item.getId() == 0)
            return null;
        return serv.createOrUpdate(item);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable int id) {
        return serv.delete(id);
    }
}

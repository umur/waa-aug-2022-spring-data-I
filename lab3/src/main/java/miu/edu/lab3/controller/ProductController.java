package miu.edu.lab3.controller;

import miu.edu.lab3.dto.*;
import miu.edu.lab3.entity.Product;
import miu.edu.lab3.service.ProductService;
import miu.edu.lab3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll()
    {
        var result = service.getAll();

        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailsDto> getById(@PathVariable int id)
    {
        return ResponseEntity.status(200).body(service.getById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ProductCreateDto pro)
    {
        service.save(pro);
        return ResponseEntity.status(201).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody ProductCreateDto pro) throws Exception {
        service.update(id, pro);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable int id)
    {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
    @GetMapping("/filtet-by-minprice")
    public ResponseEntity<List<ProductDto>> filterByMinPrice(@RequestParam float minPrice){

        var r =service.findByMinPrice(minPrice);
        return ResponseEntity.status(HttpStatus.OK).body(r);
    }

    @GetMapping("/filtet-by-cat-and-maxprice")
    public ResponseEntity<List<ProductDto>>  filterByCatAndMaxPrice(@RequestParam float maxPrice, @RequestParam String  cat){
        var r =service.findByMaxPriceAndCatName(maxPrice, cat);
        return ResponseEntity.status(HttpStatus.OK).body(r);
    }
}

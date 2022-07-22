package lab3.phase.controller;

import lab3.phase.dto.ProductDTO;
import lab3.phase.dto.ReviewDTO;
import lab3.phase.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reviews")
public class ReviewController {
    private IReviewService serv;

    @Autowired
    public ReviewController(IReviewService serv) {
        this.serv = serv;
    }

    @PostMapping
    public ReviewDTO create(@RequestBody ReviewDTO item) {
        return serv.createOrUpdate(item);
    }

    @GetMapping
    public List<ReviewDTO> read() {
        return serv.read();
    }

    @PutMapping
    public ReviewDTO update(@RequestBody ReviewDTO item) {
        if (item.getId() == 0)
            return null;
        return serv.createOrUpdate(item);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable int id) {
        return serv.delete(id);
    }
}

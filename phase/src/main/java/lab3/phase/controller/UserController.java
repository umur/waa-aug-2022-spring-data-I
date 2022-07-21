package lab3.phase.controller;

import lab3.phase.dto.ReviewDTO;
import lab3.phase.dto.UserDTO;
import lab3.phase.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private IUserService serv;

    @Autowired
    public UserController(IUserService serv) {
        this.serv = serv;
    }

    @PostMapping
    public UserDTO create(@RequestBody UserDTO item) {
        return serv.createOrUpdate(item);
    }

    @GetMapping
    public List<UserDTO> read() {
        return serv.read();
    }

    @PutMapping
    public UserDTO update(@RequestBody UserDTO item) {
        if (item.getId() == 0)
            return null;
        return serv.createOrUpdate(item);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable int id) {
        return serv.delete(id);
    }
}

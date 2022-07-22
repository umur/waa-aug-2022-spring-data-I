package lab3.phase.controller;

import lab3.phase.dto.AddressDTO;
import lab3.phase.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("addresses")
public class AddressController {
    private IAddressService serv;

    @Autowired
    public AddressController(IAddressService serv) {
        this.serv = serv;
    }

    @PostMapping
    public AddressDTO create(@RequestBody AddressDTO address) {
        return serv.createOrUpdate(address);
    }

    @GetMapping
    public List<AddressDTO> read() {
        return serv.read();
    }

    @PutMapping
    public AddressDTO update(@RequestBody AddressDTO address) {
        if (address.getId() == 0)
            return null;
        return serv.createOrUpdate(address);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable int id) {
        return serv.delete(id);
    }
}

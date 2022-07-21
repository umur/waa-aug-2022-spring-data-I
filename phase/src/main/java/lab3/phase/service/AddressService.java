package lab3.phase.service;

import lab3.phase.dto.AddressDTO;
import lab3.phase.entity.Address;
import lab3.phase.repository.IAddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService implements IAddressService {
    private IAddressRepository repo;
    private ModelMapper mapper;

    @Autowired
    public AddressService(IAddressRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public AddressDTO createOrUpdate(AddressDTO item) {
        return mapper.map(repo.save(mapper.map(item, Address.class)), AddressDTO.class);
    }

    @Override
    public List<AddressDTO> read() {
        var data = repo.findAll();
        List<AddressDTO> result = new ArrayList<>();
        data.forEach(e -> result.add(mapper.map(e, AddressDTO.class)));
        return result;
    }

    @Override
    public Boolean delete(int id) {
        var data = repo.findById(id);
        if (data.isPresent())
        {
            repo.delete(data.get());
            return true;
        }
        return false;
    }
}

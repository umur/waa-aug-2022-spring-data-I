package lab3.phase.service;

import lab3.phase.dto.UserDTO;
import lab3.phase.entity.User;
import lab3.phase.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{
    private IUserRepository repo;
    private ModelMapper mapper;

    @Autowired
    public UserService(IUserRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public UserDTO createOrUpdate(UserDTO item) {
        return mapper.map(repo.save(mapper.map(item, User.class)), UserDTO.class);
    }

    @Override
    public List<UserDTO> read() {
        var data = repo.findAll();
        List<UserDTO> result = new ArrayList<>();
        data.forEach(e -> result.add(mapper.map(e, UserDTO.class)));
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

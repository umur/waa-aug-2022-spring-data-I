package lab3.phase.service;

import lab3.phase.dto.ReviewDTO;
import lab3.phase.entity.Review;
import lab3.phase.repository.IReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService implements IReviewService{
    private IReviewRepository repo;
    private ModelMapper mapper;

    @Autowired
    public ReviewService(IReviewRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public ReviewDTO createOrUpdate(ReviewDTO item) {
        return mapper.map(repo.save(mapper.map(item, Review.class)), ReviewDTO.class);
    }

    @Override
    public List<ReviewDTO> read() {
        var data = repo.findAll();
        List<ReviewDTO> result = new ArrayList<>();
        data.forEach(e -> result.add(mapper.map(e, ReviewDTO.class)));
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

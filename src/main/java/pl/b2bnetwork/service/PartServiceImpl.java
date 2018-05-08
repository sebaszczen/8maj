package pl.b2bnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.b2bnetwork.domain.Part;
import pl.b2bnetwork.repository.PartRepository;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {
    @Autowired
    private PartRepository partRepository;

    @Override
    public List<Part> findAll() {
        return partRepository.findAll();
    }

    @Override
    public Part findById(Long id) {
        return partRepository.findOne(id);
    }

    @Override
    public void save(Part part) {
        partRepository.save(part);
    }

    @Override
    public void delete(Long id) {
        partRepository.delete(id);
    }
}

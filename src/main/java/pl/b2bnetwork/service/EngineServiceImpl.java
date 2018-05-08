package pl.b2bnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.b2bnetwork.domain.Engine;
import pl.b2bnetwork.repository.EngineRepository;

import java.util.List;

@Service
public class EngineServiceImpl implements EngineService {
    @Autowired
    private EngineRepository engineRepository;

    @Override
    public List<Engine> findAll() {
        return engineRepository.findAll() ;
    }

    @Override
    public Engine findById(Long id) {
        return engineRepository.findOne(id);
    }

    @Override
    public void save(Engine engine) {
        engineRepository.save(engine);
    }

    @Override
    public void delete(Long id) {
        engineRepository.delete(id);
    }
}
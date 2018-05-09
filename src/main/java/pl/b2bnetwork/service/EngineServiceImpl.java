package pl.b2bnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.b2bnetwork.domain.Engine;
import pl.b2bnetwork.domain.Part;
import pl.b2bnetwork.repository.EngineRepository;
import pl.b2bnetwork.repository.PartRepository;

import java.util.List;

@Service
public class EngineServiceImpl implements EngineService {
    @Autowired
    private EngineRepository engineRepository;
    @Autowired
    private PartRepository partRepository;

    @Override
    public List<Engine> findAll() {
        return engineRepository.findAll() ;
    }

    @Override
    public Engine findById(Long id) {
        return engineRepository.findOne(id);
    }

    @Override
    public void save(Engine engine, Long id) {
        Part part =  partRepository.findOne(id);
        engine.getParts().add(part);
        engineRepository.save(engine);
        part.setEngine(engine);
        partRepository.save(part);
    }

    @Override
    public void delete(Long id) {
        engineRepository.delete(id);
    }
}

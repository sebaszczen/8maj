package pl.b2bnetwork.service;

import pl.b2bnetwork.domain.Engine;

import java.util.List;

public interface EngineService {
    List<Engine> findAll();
    Engine findById(Long id);
    void save(Engine engine, Long id);
    void delete(Long id);
}

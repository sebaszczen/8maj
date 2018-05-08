package pl.b2bnetwork.service;

import pl.b2bnetwork.domain.Part;

import java.util.List;

public interface PartService {
    List<Part> findAll();
    Part findById(Long id);
    void save(Part part);
    void delete(Long id);
}

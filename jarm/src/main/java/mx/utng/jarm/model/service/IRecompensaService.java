package mx.utng.jarm.model.service;

import java.util.List;

import mx.utng.jarm.model.entity.Recompensa;


public interface IRecompensaService {
    List<Recompensa> list();
    void save(Recompensa recompensa);
    Recompensa getById(Long id);
    void delete(Long id);
}

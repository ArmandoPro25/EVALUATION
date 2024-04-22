package mx.utng.jarm.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.jarm.model.entity.Recompensa;

@Repository
public class RecompensaDaoImpl implements IRecompensaDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Recompensa> list() {
        return em.createQuery("from Recompensa").getResultList();
    }

    @Override
    public void save(Recompensa recompensa) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(recompensa.getId() != null && recompensa.getId()>0){
            em.merge(recompensa);
        }else{
            //Registro nuevo al usar persist
            em.persist(recompensa);
        }
    }

    @Override
    public Recompensa getById(Long id) {
        return em.find(Recompensa.class, id);
    }

    @Override
    public void delete(Long id) {
      Recompensa recompensa = getById(id);
      em.remove(recompensa);
    }
    

}
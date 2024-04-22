package mx.utng.jarm.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.jarm.model.entity.Bitacora;

@Repository
public class BitacoraDaoImpl implements IBitacoraDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Bitacora> list() {
        return em.createQuery("from Bitacora").getResultList();
    }

    @Override
    public void save(Bitacora bitacora) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(bitacora.getId() != null && bitacora.getId()>0){
            em.merge(bitacora);
        }else{
            //Registro nuevo al usar persist
            em.persist(bitacora);
        }
    }

    @Override
    public Bitacora getById(Long id) {
        return em.find(Bitacora.class, id);
    }

    @Override
    public void delete(Long id) {
      Bitacora bitacora = getById(id);
      em.remove(bitacora);
    }
    

}
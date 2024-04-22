package mx.utng.jarm.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.jarm.model.entity.Permiso;

@Repository
public class PermisoDaoImpl implements IPermisoDao{

    //Coloco un atributo que me permitira gestionar la entidad
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Permiso> list() {
        return em.createQuery("from Permiso").getResultList();
    }

    @Override
    public void save(Permiso permiso) {
        //Si el id es distinto a nulo o mayor que cero, quiere decir que el registro ya existe lo va a modificar
        if(permiso.getId() != null && permiso.getId()>0){
            em.merge(permiso);
        }else{
            //Registro nuevo al usar persist
            em.persist(permiso);
        }
    }

    @Override
    public Permiso getById(Long id) {
        return em.find(Permiso.class, id);
    }

    @Override
    public void delete(Long id) {
      Permiso permiso = getById(id);
      em.remove(permiso);
    }
    

}
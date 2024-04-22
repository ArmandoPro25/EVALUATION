package mx.utng.jarm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.jarm.model.dao.IBitacoraDao;
import mx.utng.jarm.model.entity.Bitacora;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class BitacoraServiceImpl implements IBitacoraService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IBitacoraDao bitacoraDao;

    @Transactional(readOnly = true)
    @Override
    public List<Bitacora> list() {
        return bitacoraDao.list();
    }

    @Transactional
    @Override
    public void save(Bitacora bitacora) {
        bitacoraDao.save(bitacora);
    }

    @Transactional(readOnly = true)
    @Override
    public Bitacora getById(Long id) {
        return bitacoraDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        bitacoraDao.delete(id);
    }
    
}

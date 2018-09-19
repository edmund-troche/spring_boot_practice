package org.troche.spring.application.exercise.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.troche.spring.application.exercise.model.Device;

@Repository
@Transactional
public class DeviceDaoImpl implements DeviceDao {

    @PersistenceContext private EntityManager entityManager;

    @Override
    public Long save(final Device device) {
        entityManager.persist(device);

        return device.getId();
    }

    @Override
    public Device getById(final Long id) {
        return entityManager.find(Device.class, id);
    }

    // TODO Maybe pass a order-by criteria, e.g.:
    //     .../devices?order=+id	(ascending by id)
    //     .../devices?order=-id	(descending by id)
    //     .../devices?order=+name,-id	(ascending by name, descending by id)
    //
    //     so parameter that takes the "order" parameter value.
    @Override
    public List<Device> getAll() {
        final String DEVICE_QUERY_GET_ALL = "FROM Device ORDER BY name";

        return (List<Device>) entityManager.createQuery(DEVICE_QUERY_GET_ALL).getResultList();
    }

    @Override
    public boolean deleteById(final Long id) {
        final String DEVICE_QUERY_GET = "FROM Device WHERE id = :id";
        final int DEVICES_FOUND =
                entityManager
                        .createQuery(DEVICE_QUERY_GET)
                        .setParameter("id", id)
                        .getResultList()
                        .size();

        if (DEVICES_FOUND > 0) {
            entityManager.remove(getById(id));
            return true;
        }

        return false;
    }

    @Override
    public boolean deviceExists(final Device device) {
        final String DEVICE_QUERY_NAME = "FROM Device WHERE name = :name";
        final int DEVICES_FOUND =
                entityManager
                        .createQuery(DEVICE_QUERY_NAME)
                        .setParameter("name", device.getName())
                        .getResultList()
                        .size();

        return DEVICES_FOUND > 0 ? true : false;
    }
}

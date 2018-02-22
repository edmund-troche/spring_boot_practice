package org.troche.spring.application.exercise.dao;

import java.util.List;

import org.troche.spring.application.exercise.model.Device;

public interface DeviceDao {

    public Long save(final Device device);

    public Device getById(final Long id);

    public List<Device> getAll();

    public boolean deleteById(final Long id);

    public boolean deviceExists(final Device device);
}

package org.troche.spring.application.exercise.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.troche.spring.application.exercise.dao.DeviceDao;
import org.troche.spring.application.exercise.model.Device;

/**
 * Device management service.
 */
@Service
public class DeviceManagementServiceImpl implements DeviceManagementService {
    @Autowired
    private DeviceDao deviceDao;

    /**
     * Find a device by its id.
     *
     * @param id unique device id, not null.
     *
     * @returns a {@code Device} identied by id, if found.
     */
    @Override
    public Device getDeviceById(final Long id) {
	Objects.requireNonNull(id, "id");

        return deviceDao.getById(id);
    }

    @Override
    public List<Device> getDevices() {
        return deviceDao.getAll();
    }

    /**
     * Delete a device by its id.
     *
     * @param id unique device id, not null.
     *
     * @returns a true if the device was deleted, or false otherwise.
     */
     @Override
     public boolean deleteById(final Long id) {
	Objects.requireNonNull(id, "id");

        return deviceDao.deleteById(id);
    }


    /**
     * Add a device.
     *
     * @param device is the device to add to the database, not null.
     *
     * @returns a true if the device was added, or false otherwise.
     */
    @Override
    public boolean add(final Device device) {
        if (deviceDao.deviceExists(device)) {
            return false;
	}

        deviceDao.save(device);

	return true;
    }
}

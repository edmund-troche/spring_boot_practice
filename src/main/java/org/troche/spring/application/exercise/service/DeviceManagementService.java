package org.troche.spring.application.exercise.service;

import java.util.List;
import org.troche.spring.application.exercise.model.Device;

/** Device management service. */
public interface DeviceManagementService {
    /**
     * Find a device by its id.
     *
     * @param id unique device id, not null.
     * @returns a {@code Device} identied by id, if found.
     */
    public Device getDeviceById(final Long id);

    /**
     * Get all devices.
     *
     * @returns a {@code List<Device>}
     */
    public List<Device> getDevices();

    /**
     * Delete a device by its id.
     *
     * @param id unique device id, not null.
     * @returns a true if the device was deleted, or false otherwise.
     */
    public boolean deleteById(final Long id);

    /**
     * Add a device.
     *
     * @param device is the device to add to the database, not null.
     * @returns a true if the device was added, or false otherwise.
     */
    public boolean add(final Device device);
}

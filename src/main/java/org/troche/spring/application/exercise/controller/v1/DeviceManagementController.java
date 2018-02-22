package org.troche.spring.application.exercise.controller.v1;

import java.util.List;
import java.util.Locale;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import org.troche.spring.application.exercise.model.Device;
import org.troche.spring.application.exercise.service.DeviceManagementService;

/**
 * Controller to handle the HTTP requests for the device manager.
 */
@RestController
public class DeviceManagementController extends BaseController {
    @Autowired
    DeviceManagementService deviceManagementService;

    /**
     * Handle device creation.
     *
     * Devices are created calling POST on the "/devices" URL path.
     *
     * @return device representation in JSON.
     */
    @PostMapping(value = "/devices", consumes = MediaType.APPLICATION_JSON_VALUE) 
    public ResponseEntity<?> createDevice(@RequestBody Device device, UriComponentsBuilder builder) {
	final boolean isAdded = deviceManagementService.add(device);
        if (!isAdded) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

	// Set HTTP Location header to the URL for the new resource instance.
        final HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path(UrlPath.BASE_PATH_V1 + "/devices/{id}").buildAndExpand(device.getId()).toUri());

        return new ResponseEntity(device, headers, HttpStatus.CREATED);
    }
 
    /**
     * Handle device deletion calling HTTP DELETE on the "/devices/{id}" URL path.
     *
     * @return device representation in JSON.
     */
    @DeleteMapping(value = "/devices/{id}") 
    public ResponseEntity<?> deleteDevice(
	    @RequestHeader(value = "prefer", defaultValue = "return=minimal") String preferHeaderValue, 
	    @PathVariable("id") Long id) {
	/**
	 * return the representation of the deleted deviceif the "Prefer" HTTP header
	 * is set to "return=representation".
	 */
	boolean returnRepresentation = false;
	Device device = null;
	if (preferHeaderValue.equalsIgnoreCase("return=representation")) {
	    returnRepresentation = true;

	    device = deviceManagementService.getDeviceById(id);
	    // if we can't find the device then don't bother with attempting a delete.
	    if (device == null) {
                return new ResponseEntity<Void>(HttpStatus.CONFLICT);
            }
	}

	final boolean isDeleted = deviceManagementService.deleteById(id);
        if (!isDeleted) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

	if (returnRepresentation) {
            return ResponseEntity.ok().body(device);
	}

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
 
    /**
     * Handle device query calling GET on the "/devices/{id}" URL path.
     *
     * @return device representation in JSON.
     */
    @GetMapping(value = "/devices/{id}") 
    public ResponseEntity<?> getDevice(@PathVariable("id") Long id) {
	final Device device = deviceManagementService.getDeviceById(id);
	if (device == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok().body(device);
    }
 
    /**
     * Handle device query calling GET on the "/devices" URL path.
     *
     * @return list of devices in JSON.
     */
    @GetMapping(value = "/devices") 
    public ResponseEntity<?> getDevices() {
	final List<Device> devices = deviceManagementService.getDevices();

        return ResponseEntity.ok().body(devices);
    }
}

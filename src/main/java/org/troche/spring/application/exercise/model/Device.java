package org.troche.spring.application.exercise.model;

import java.util.Date;
import java.util.Objects;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Class to represent a device.
 */
@Entity
public class Device {
    /** 
     * Device id, not null.
     *
     * The device id is unique and generated.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    /** 
     * Device name, not null. 
     *
     * The device name is a user specified label that is unique to
     * the device.
     */
    private String name;

    /** Device description, nullable. */
    private String description;

    /** Creation date, not null */
    private Date creationDate;

    public Device() {
        setName("some name");
	setCreationDate(new Date());
    }

    /**
     * Create a device object.
     *
     * @param aName actual greeting message, not null.
     * @param aDescription device description, nullable.
     */
    //public Device(final String aName, @Nullable final String aDescription) {
    public Device(final String aName, final String aDescription) {
        setName(aName);
        setDescription(aDescription);
	setCreationDate(new Date());
    }

    /**
     * Get the device id.
     *
     * @return device id, not null.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the device id.
     *
     * @param theId device id, not null.
     */
    public void setId(final Long theId) {
        this.id = Objects.requireNonNull(theId, "id");
    }

    /**
     * Get the device name.
     *
     * @return device name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the device name.
     *
     * @param aName device name, not null.
     */
    public void setName(final String aName) {
        this.name = Objects.requireNonNull(aName, "name");
    }

    /**
     * Get the device description.
     *
     * @return device description, nullable.
     */
    //@Nullable
    public String getDescription() {
        return description;
    }

    /**
     * Set the device description.
     *
     * @param aDescription device description, nullable.
     */
    //public void setDescription(@Nullable final String aDescription) {
    public void setDescription(final String aDescription) {
        this.description = aDescription;
    }

    /**
     * Get the device creation date.
     *
     * @return device creation date, not null.
     */
    public Date getCreationDate() {
        return new Date(creationDate.getTime());
    }

    /**
     * Set the device creation date.
     *
     * @param aCreationDate device creation date, non null.
     */
    public void setCreationDate(final Date aCreationDate) {
        this.creationDate = new Date(Objects.requireNonNull(aCreationDate, "creationDate").getTime());
    }

    @Override
    public String toString() {
        return "Device [id=" + id + ", name=" + name + ", description=" + description 
		+ ", creationDate=" + creationDate + "]";
    }
}

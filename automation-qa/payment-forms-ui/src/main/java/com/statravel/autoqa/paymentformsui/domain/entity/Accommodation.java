package com.statravel.autoqa.paymentformsui.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author STA Development Team
 *
 */
@Entity
@Table(name = "a_ui_payment_form_accommodation")
public class Accommodation implements Serializable {

    private static final long serialVersionUID = -257499051396575759L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "rooms", columnDefinition = "MEDIUMINT")
    private String rooms;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "check_in_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDate;

    @Column(name = "check_out_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDate;

    @Column(name = "nights", columnDefinition = "MEDIUMINT")
    private Short numberOfNights;

    @Column(name = "special_remarks", columnDefinition = "TEXT")
    private String specialRemarks;

    @Column(name = "active", columnDefinition = "BIT")
    private boolean active;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(final String address) {
        this.address = address;
    }

    /**
     * @return the rooms
     */
    public String getRooms() {
        return rooms;
    }

    /**
     * @param rooms
     *            the rooms to set
     */
    public void setRooms(final String rooms) {
        this.rooms = rooms;
    }

    /**
     * @return the roomType
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * @param roomType
     *            the roomType to set
     */
    public void setRoomType(final String roomType) {
        this.roomType = roomType;
    }

    /**
     * @return the checkInDate
     */
    public Date getCheckInDate() {
        return checkInDate;
    }

    /**
     * @param checkInDate
     *            the checkInDate to set
     */
    public void setCheckInDate(final Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * @return the checkOutDate
     */
    public Date getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * @param checkOutDate
     *            the checkOutDate to set
     */
    public void setCheckOutDate(final Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    /**
     * @return the numberOfNights
     */
    public Short getNumberOfNights() {
        return numberOfNights;
    }

    /**
     * @param numberOfNights
     *            the numberOfNights to set
     */
    public void setNumberOfNights(final Short numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    /**
     * @return the specialRemarks
     */
    public String getSpecialRemarks() {
        return specialRemarks;
    }

    /**
     * @param specialRemarks
     *            the specialRemarks to set
     */
    public void setSpecialRemarks(final String specialRemarks) {
        this.specialRemarks = specialRemarks;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active
     *            the active to set
     */
    public void setActive(final boolean active) {
        this.active = active;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Accommodation [id=" + id + ", name=" + name + ", city=" + city + ", address=" + address + ", rooms=" + rooms + ", roomType="
                + roomType + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", numberOfNights=" + numberOfNights
                + ", specialRemarks=" + specialRemarks + ", active=" + active + "]";
    }

}

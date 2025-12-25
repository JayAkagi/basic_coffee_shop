package com.chilling.projectOne.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalTime;

@Entity
@Table(name = "shop_details")
public class ShopDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "open_hours", nullable = false)
    private LocalTime openHours;

    @Column(name ="close_hours", nullable = false)
    private LocalTime closeHours;

    private String instagram;
    private String facebook;
    private String twitter;

    protected ShopDetails(){}

    public ShopDetails(
            String name,
            LocalTime openHours,
            LocalTime closeHours,
            String instagram,
            String facebook,
            String twitter
    ){
        this.name = name;
        this.openHours = openHours;
        this.closeHours = closeHours;
        this.instagram = instagram;
        this.facebook = facebook;
        this.twitter = twitter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getOpenHours() {
        return openHours;
    }

    public void setOpenHours(LocalTime openHours) {
        this.openHours = openHours;
    }

    public LocalTime getCloseHours() {
        return closeHours;
    }

    public void setCloseHours(LocalTime closeHours) {
        this.closeHours = closeHours;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
}

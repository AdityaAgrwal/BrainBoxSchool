package com.brainbox.school.dto;

import java.util.Arrays;

/**
 * Created by adityaagrawal on 31/03/16.
 */
public class SchoolDTO {
    private String email;
    private String name;
    private String admin;
    private String[] mobile;
    private String id;
    private FaqDTO[] _faqs;
    private FeedbackDTO[] _feedbacks;
    private AddressDTO[] _addresses;
    private String branch;
    private String mission;
    private String location;
    private String[] facilities;
    private String[] infrastructure;
    private String about;
    private String logoLink;
    private String imageLink;
    private String[] classes;
    private SocialMediaDTO[] socialMedia;
    private String board;
    private String admissionProcess;
    private String website;
    private Integer reputation;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String[] getFacilities() {
        return facilities;
    }

    public void setFacilities(String[] facilities) {
        this.facilities = facilities;
    }

    public String[] getInfrastructure() {
        return infrastructure;
    }

    public void setInfrastructure(String[] infrastructure) {
        this.infrastructure = infrastructure;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLogoLink() {
        return logoLink;
    }

    public void setLogoLink(String logoLink) {
        this.logoLink = logoLink;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String[] getClasses() {
        return classes;
    }

    public void setClasses(String[] classes) {
        this.classes = classes;
    }

    public SocialMediaDTO[] getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(SocialMediaDTO[] socialMedia) {
        this.socialMedia = socialMedia;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getAdmissionProcess() {
        return admissionProcess;
    }

    public void setAdmissionProcess(String admissionProcess) {
        this.admissionProcess = admissionProcess;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String[] getMobile() {
        return mobile;
    }

    public void setMobile(String[] mobile) {
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FaqDTO[] get_faqs() {
        return _faqs;
    }

    public void set_faqs(FaqDTO[] _faqs) {
        this._faqs = _faqs;
    }

    public FeedbackDTO[] get_feedbacks() {
        return _feedbacks;
    }

    public void set_feedbacks(FeedbackDTO[] _feedbacks) {
        this._feedbacks = _feedbacks;
    }

    public AddressDTO[] get_addresses() {
        return _addresses;
    }

    public void set_addresses(AddressDTO[] _addresses) {
        this._addresses = _addresses;
    }


    @Override
    public String toString() {
        return "SchoolDTO{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", admin='" + admin + '\'' +
                ", mobile=" + Arrays.toString(mobile) +
                ", id='" + id + '\'' +
                ", _faqs=" + Arrays.toString(_faqs) +
                ", _feedbacks=" + Arrays.toString(_feedbacks) +
                ", _addresses=" + Arrays.toString(_addresses) +
                ", branch='" + branch + '\'' +
                ", mission='" + mission + '\'' +
                ", location='" + location + '\'' +
                ", facilities=" + Arrays.toString(facilities) +
                ", infrastructure=" + Arrays.toString(infrastructure) +
                ", about='" + about + '\'' +
                ", logoLink='" + logoLink + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", classes=" + Arrays.toString(classes) +
                ", socialMedia=" + Arrays.toString(socialMedia) +
                ", board='" + board + '\'' +
                ", admissionProcess='" + admissionProcess + '\'' +
                ", website='" + website + '\'' +
                ", reputation=" + reputation +
                '}';
    }
}

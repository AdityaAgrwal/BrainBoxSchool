package com.brainbox.school.dto;

/**
 * Created by adityaagrawal on 09/02/16.
 */
public class SessionDTO {
    private String gcmKey;
    private SchoolDTO schoolDTO;
    private HeaderDTO headerDTO;

    @Override
    public String toString() {
        return "SessionDTO{" +
                "gcmKey='" + gcmKey + '\'' +
                ", schoolDTO=" + schoolDTO +
                ", headerDTO=" + headerDTO +
                '}';
    }

    public SchoolDTO getSchoolDTO() {
        return schoolDTO;
    }

    public void setSchoolDTO(SchoolDTO schoolDTO) {
        this.schoolDTO = schoolDTO;
    }

    public HeaderDTO getHeaderDTO() {
        return headerDTO;
    }

    public void setHeaderDTO(HeaderDTO headerDTO) {
        this.headerDTO = headerDTO;
    }

    public String getGcmKey() {
        return gcmKey;
    }

    public void setGcmKey(String gcmKey) {
        this.gcmKey = gcmKey;
    }

}

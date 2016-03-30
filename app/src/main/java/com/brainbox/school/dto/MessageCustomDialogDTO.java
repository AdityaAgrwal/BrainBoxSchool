package com.brainbox.school.dto;

/**
 * Created by Dell on 1/4/2016.
 */
public class MessageCustomDialogDTO {

    private String title;
    private String message;
    private String button;


    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

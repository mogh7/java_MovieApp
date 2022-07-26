package movieProject;

import javax.swing.*;

public class Movie {

    private String name;
    private String disc;
    private ImageIcon image;
    private String url;

    public Movie(String name, String disc, ImageIcon image) {
        this.name = name;
        this.disc = disc;
        this.image = image;
    }

    public Movie(String name, String disc, ImageIcon image, String url) {
        this.name = name;
        this.disc = disc;
        this.image = image;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }


}

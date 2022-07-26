package movieProject;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerAccount implements Serializable {
    private String username;
    private String password;
    private ArrayList<Movie> like;

    public CustomerAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Movie> getLike() {
        return like;
    }

    public void setLike(ArrayList<Movie> like) {
        this.like = like;
    }

    public void addLikeMovie(Movie m){
        like.add(m);
    }

    @Override
    public String toString() {
        return "CustomerAccount{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", like=" + like +
                '}';
    }
}

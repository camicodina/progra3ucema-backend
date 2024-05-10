package src.main.java.com.model;

public abstract class User {

    private String username;
    private String name;
    private String email;
    private String password;

    public User(String username, String name, String email, String password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters y Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPass(String newPass) {
        this.password = newPass;
    }

    // Acciones 
    public void Ingresar(){

    }

    public void Follow(Etiqueta etiqueta){

    }

    public void CrearPost(Post post){
    }


}

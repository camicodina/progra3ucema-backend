package src.main.java.com.model;

import java.time.LocalDate;

public class Profesor extends User {
    private LocalDate fechaIngreso;

    public Profesor(String username, String name, String email, String password) {
        super(username, name, email, password);
    }

    public void BorrarPost(Post post){
        
    }
}

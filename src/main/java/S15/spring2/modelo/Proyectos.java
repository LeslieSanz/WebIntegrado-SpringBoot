package S15.spring2.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="proyecto")

public class Proyectos {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    int id;
    String nombre;
    String Descripción;

    public Proyectos() {
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return Descripción;
    }

    public void setDescripción(String Descripción) {
        this.Descripción = Descripción;
    }

    
    
    
    
}

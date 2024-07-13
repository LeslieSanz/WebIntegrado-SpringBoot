package S15.spring2.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="curso")

public class Cursos {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    int id;
    String nombreCurso;
    double precio;

    public Cursos() {
    }

    public int getId() {
        return id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    
    
}

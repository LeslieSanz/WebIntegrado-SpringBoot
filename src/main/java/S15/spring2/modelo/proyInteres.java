package S15.spring2.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="proyInteres")

public class proyInteres {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    int id;
    String proyecto;
    String nomLista;

    public proyInteres() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getNomLista() {
        return nomLista;
    }

    public void setNomLista(String nomLista) {
        this.nomLista = nomLista;
    }

    
    
    
}

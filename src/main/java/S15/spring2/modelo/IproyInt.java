/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package S15.spring2.modelo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IproyInt extends CrudRepository<proyInteres, Integer> {
    //Crear un metodo
    List<proyInteres> findByNombreContaining(String palabra);
    
    
    
    
    
}

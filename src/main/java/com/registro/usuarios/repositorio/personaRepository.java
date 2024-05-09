package com.registro.usuarios.repositorio;



import com.registro.usuarios.modelo.personas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface personaRepository extends JpaRepository< personas, Long>{

    public Object findById(int id);
    
    @Query("SELECT p FROM personas p WHERE p.departamento LIKE %?1%")
    public List<personas> findAll(String keyword);
    
    
    
@Query("SELECT SUM(CantidaDeHabitantes) FROM personas")
int getTotalHabitantes();


    
}


package com.registro.usuarios.servicio;

import com.registro.usuarios.modelo.personas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.repositorio.personaRepository;

@Service
public class personaService {
    @Autowired
    private personaRepository personaRepository;
    
    public List<personas> listAll(String keyword){
        if(keyword !=null){
            return personaRepository.findAll(keyword);
        }
        return personaRepository.findAll();
        
    }
    public void save(personas personas){
        personaRepository.save(personas);
        
    }
    
    public personas get(int id){
        return (personas) personaRepository.findById(id);
        
    }
    
    public void delete(Long id){
        personaRepository.deleteById(id);
        
    }
    
    public int getTotalHabitantes() {
    return personaRepository.getTotalHabitantes();
}

}

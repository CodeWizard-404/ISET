package com.DSI.TP1.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DSI.TP1.Entities.Livre;
import com.DSI.TP1.services.IServiceLivre;

@RestController
public class LivreRestController {

    @Autowired
    IServiceLivre iServiceLivre;
    
    @GetMapping("/livre")
    public List<Livre> getAll(){
        return iServiceLivre.getAllLivre();
    }
    
    @GetMapping("/livre/{id}")
    public Livre getOne(@PathVariable("id") int id){
        return iServiceLivre.findLivre(id);
    }
    
    @PostMapping("/livre")
    public boolean addEtudiant(@RequestBody Livre livre) {
        return iServiceLivre.saveLivre(livre);
    }
    
    @PutMapping("/livre/{id}")
    public Livre updateEtudiant(@RequestBody Livre livre,@PathVariable("id") int id) {
        return iServiceLivre.updateLivre(livre, id);
    }
    
    @DeleteMapping("/livre/{id}")
    public boolean deleteOne(@PathVariable("id") int id){
        return iServiceLivre.deletLivre(id);
    }
}
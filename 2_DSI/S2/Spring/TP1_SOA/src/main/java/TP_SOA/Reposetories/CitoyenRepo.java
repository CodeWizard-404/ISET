package TP_SOA.Reposetories;

import org.springframework.data.jpa.repository.JpaRepository;
import TP_SOA.entities.Citoyen;


public interface CitoyenRepo extends JpaRepository<Citoyen,String>{
	

}

package isepdiamniadio.edu.sn.DroitCitoyen.repositories;

import isepdiamniadio.edu.sn.DroitCitoyen.entities.Role;
import isepdiamniadio.edu.sn.DroitCitoyen.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    @Query("select ur.role from UserRole ur where ur.user.id = :idUser")
    List<Role>getRolesByUser(Integer idUser);
}
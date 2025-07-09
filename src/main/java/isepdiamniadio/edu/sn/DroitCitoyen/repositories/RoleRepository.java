package isepdiamniadio.edu.sn.DroitCitoyen.repositories;

import isepdiamniadio.edu.sn.DroitCitoyen.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByNom(String nom);
}
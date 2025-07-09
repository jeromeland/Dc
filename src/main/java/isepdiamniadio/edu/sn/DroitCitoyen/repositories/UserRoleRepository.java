package isepdiamniadio.edu.sn.DroitCitoyen.repositories;

import isepdiamniadio.edu.sn.DroitCitoyen.entities.UserRole;
import isepdiamniadio.edu.sn.DroitCitoyen.entities.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
}
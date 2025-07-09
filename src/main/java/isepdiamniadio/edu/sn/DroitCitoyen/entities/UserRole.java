package isepdiamniadio.edu.sn.DroitCitoyen.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "user_role")
public class UserRole {

    @EmbeddedId
    private UserRoleId id;

    @MapsId("roleId")
    @ManyToOne
    private Role role;

    @MapsId("userId")
    @ManyToOne
    private Utilisateur user;


}
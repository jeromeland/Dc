package isepdiamniadio.edu.sn.DroitCitoyen.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class UserRoleId {

    private Integer roleId;
    private Integer userId;
}

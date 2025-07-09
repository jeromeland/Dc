package isepdiamniadio.edu.sn.DroitCitoyen.init;

import isepdiamniadio.edu.sn.DroitCitoyen.entities.Role;
import isepdiamniadio.edu.sn.DroitCitoyen.repositories.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Profile({"dev","test"})
@Order(1)
public class InitRole implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger("InitRole");
    private final RoleRepository roleRepository;

    public InitRole(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Initialisation des Role");

        logger.debug("Creating Role admin");
        Role roleAdmin = new Role();
        roleAdmin.setNom("ROLE_admin");
        roleRepository.save(roleAdmin);

        logger.debug("Creating Role utilisateur");
        Role roleUser = new Role();
        roleUser.setNom("ROLE_user");
        roleRepository.save(roleUser);

        logger.debug("Creating Role manager");
        Role roleManager = new Role();
        roleManager.setNom("ROLE_manager");
        roleRepository.save(roleManager);

    }
}

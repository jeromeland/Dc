package isepdiamniadio.edu.sn.DroitCitoyen.init;

import isepdiamniadio.edu.sn.DroitCitoyen.entities.Role;
import isepdiamniadio.edu.sn.DroitCitoyen.entities.UserRole;
import isepdiamniadio.edu.sn.DroitCitoyen.entities.UserRoleId;
import isepdiamniadio.edu.sn.DroitCitoyen.entities.Utilisateur;
import isepdiamniadio.edu.sn.DroitCitoyen.repositories.RoleRepository;
import isepdiamniadio.edu.sn.DroitCitoyen.repositories.UserRoleRepository;
import isepdiamniadio.edu.sn.DroitCitoyen.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Profile({"dev","test"})
@Order(2)
public class InitUtilisateur implements CommandLineRunner {

    private final RoleRepository roleRepository;
    @Value("${isep.droitcitoyen.utilisateur.admin.prenom}")
    private String adminPrenom;

    @Value("${isep.droitcitoyen.utilisateur.admin.nom}")
    private String adminNom;

    @Value("${isep.droitcitoyen.utilisateur.admin.email}")
    private String adminEmail;

    @Value("${isep.droitcitoyen.utilisateur.test.nombre}")
    private Integer nbUser;
    private final UtilisateurRepository utilisateurRepository;
    private final UserRoleRepository userRoleRepository;

    public InitUtilisateur(UtilisateurRepository utilisateurRepository, RoleRepository roleRepository,
                           UserRoleRepository userRoleRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Initialisation Utilisateur");
        Utilisateur admin = new Utilisateur();
        admin.setPrenom(adminPrenom);
        admin.setNom(adminNom);
        admin.setEmail(adminEmail);
        admin.setPassword("admin");
        utilisateurRepository.save(admin);
        Optional<Role> roleAdmin = roleRepository.findByNom("ROLE_admin");
        Optional<Role> roleUser = roleRepository.findByNom("ROLE_user");
        Optional<Role> roleManager = roleRepository.findByNom("ROLE_manager");
        if (roleAdmin.isEmpty() || roleUser.isEmpty() || roleManager.isEmpty()) {
            throw new RuntimeException("Un des roles n'existe pas");
        }

        UserRoleId userRoleId = new UserRoleId();
        userRoleId.setRoleId(roleAdmin.get().getId());
        userRoleId.setUserId(admin.getId());

        UserRole userRole = new UserRole();
        userRole.setRole(roleAdmin.get());
        userRole.setUser(admin);
        userRole.setId(userRoleId);
        userRoleRepository.save(userRole);


//        List<Utilisateur> utilisateurs = new ArrayList();
        for (int i = 0; i < nbUser; i++) {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom("nom "+i);
            utilisateur.setPrenom("prenom"+i);
            utilisateur.setEmail("email"+i+"@exemple.com");
            utilisateur.setPassword("password"+i);

            //Genere un nombre aleatoire entre 0 et 1
            double random = Math.random();
            Role role;
            if (random < 0.8) {
                role = roleUser.get();
            } else if (random < 0.95) {
                role = roleManager.get();
            }else{
                role = roleAdmin.get();
            }
            utilisateurRepository.save(utilisateur);
            UserRoleId urId = new UserRoleId();
            urId.setRoleId(role.getId());
            urId.setUserId(utilisateur.getId());

            UserRole ur = new UserRole();
            ur.setRole(role);
            ur.setUser(utilisateur);
            ur.setId(urId);
            userRoleRepository.save(ur);
        }
    }
}

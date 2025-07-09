package isepdiamniadio.edu.sn.DroitCitoyen.sevices;

import isepdiamniadio.edu.sn.DroitCitoyen.entities.Utilisateur;
import isepdiamniadio.edu.sn.DroitCitoyen.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur>getAllUtilisateurs(){
        return utilisateurRepository.findAll();
    }
}

package tn.esprit.services;

import tn.esprit.interfaces.IPorteurService;
import tn.esprit.models.Porteur;

public class PorteurService extends ServiceUser<Porteur> implements IPorteurService {
    public PorteurService() {
        super("porteur");
    }
}

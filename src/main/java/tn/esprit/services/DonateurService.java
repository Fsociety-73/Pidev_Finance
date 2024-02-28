package tn.esprit.services;

import tn.esprit.interfaces.IDonateurService;
import tn.esprit.models.Donateur;

public class DonateurService extends ServiceUser<Donateur> implements IDonateurService {
    public DonateurService() {
        super("donateur");
    }
}

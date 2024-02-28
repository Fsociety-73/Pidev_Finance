package tn.esprit.services;

import tn.esprit.interfaces.IInvestisseurService;
import tn.esprit.models.Investisseur;

public class InvestisseurService extends ServiceUser<Investisseur> implements IInvestisseurService {
    public InvestisseurService() {
        super("investisseur");
    }
}

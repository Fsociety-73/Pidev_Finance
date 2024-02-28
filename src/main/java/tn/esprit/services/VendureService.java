package tn.esprit.services;

import tn.esprit.interfaces.IVendureService;
import tn.esprit.models.Vendure;

public class VendureService extends ServiceUser<Vendure> implements IVendureService {
    public VendureService() {
        super("vendure");
    }
}

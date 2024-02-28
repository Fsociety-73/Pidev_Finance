package tn.esprit.services;

import tn.esprit.interfaces.IProjectCreatorService;
import tn.esprit.models.ProjectCreator;

public class ProjectCreatorService extends ServiceUser<ProjectCreator> implements IProjectCreatorService {
    public ProjectCreatorService() {
        super("project_creator");
    }
}

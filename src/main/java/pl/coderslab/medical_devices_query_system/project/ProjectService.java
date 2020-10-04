package pl.coderslab.medical_devices_query_system.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public void save(Project project) {
        projectRepository.save(project);
    }

    public List<Project> findAllByActiveAndManagerId(long id){
        return projectRepository.findAllByActiveAndManagerId(id);
    }

    public Optional<Project> findProjectByActiveAndProjectId(long projectId){
        return projectRepository.findProjectByActiveAndProjectId(projectId);
    }

    public void updateProject(Project modelProject, Project dbProject){
        dbProject.getProjectDetails().setRoomName(modelProject.getProjectDetails().getRoomName());
        dbProject.getProjectDetails().setHeight(modelProject.getProjectDetails().getHeight());
        dbProject.getProjectDetails().setRoomLength(modelProject.getProjectDetails().getRoomLength());
        dbProject.getProjectDetails().setRoomWidth(modelProject.getProjectDetails().getRoomWidth());
        dbProject.setSystem(modelProject.getSystem());
        dbProject.setHospital(modelProject.getHospital());
        dbProject.setEngineer(modelProject.getEngineer());
        projectRepository.save(dbProject);
    }

    public void deleteProject(Project project){
        project.setStatus("canceled");
        project.setActive(false);
        projectRepository.save(project);
    }
}

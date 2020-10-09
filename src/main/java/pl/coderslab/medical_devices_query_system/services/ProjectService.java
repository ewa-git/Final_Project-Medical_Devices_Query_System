package pl.coderslab.medical_devices_query_system.services;

import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.medical_devices_query_system.mail.SendEmail;
import pl.coderslab.medical_devices_query_system.model.dbFIle.DbFile;
import pl.coderslab.medical_devices_query_system.model.project.Project;
import pl.coderslab.medical_devices_query_system.model.project.Status;
import pl.coderslab.medical_devices_query_system.model.user.User;
import pl.coderslab.medical_devices_query_system.repositories.ProjectRepository;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.io.IOException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final SendEmail mailSender;

    public void save(Project project) {
        projectRepository.save(project);
    }

    public List<Project> findAllByActiveAndManagerId(long id) {
        return projectRepository.findAllByActiveAndManagerId(id);
    }

    public Optional<Project> findProjectByActiveAndProjectId(long projectId) {
        return projectRepository.findProjectByActiveAndProjectId(projectId);
    }

    public void updateProject(Project modelProject, Project dbProject) {
        dbProject.getProjectDetails().setRoomName(modelProject.getProjectDetails().getRoomName());
        dbProject.getProjectDetails().setHeight(modelProject.getProjectDetails().getHeight());
        dbProject.getProjectDetails().setRoomLength(modelProject.getProjectDetails().getRoomLength());
        dbProject.getProjectDetails().setRoomWidth(modelProject.getProjectDetails().getRoomWidth());
        dbProject.setSystem(modelProject.getSystem());
        dbProject.setHospital(modelProject.getHospital());
        dbProject.setEngineer(modelProject.getEngineer());
        projectRepository.save(dbProject);
        log.debug("Zmieniono dane projektu:", dbProject);
    }

    public void deleteProject(Project project) {
        project.setStatus(Status.CANCELED.toString());
        project.setActive(false);
        projectRepository.save(project);
        log.debug("Zdeaktywowano projekt:", project);
    }

    public List<Project> findAllByStatusAndManagerId(String status, long id) {
        return projectRepository.findAllByStatusAndManagerId(status, id);
    }

    public List<Project> findAllByStatus(String status) {
        return projectRepository.findAllByStatus(status);
    }

    public void assignProject(Project project, User engineer) {
        project.setStatus(Status.IN_PROGRESS.toString());
        project.setEngineer(engineer);
        projectRepository.save(project);
        log.debug("Przypisano projekt:", project, engineer);
    }

    public void completeProject(Project project, String comments, String email) throws TemplateException, IOException, MessagingException {
        project.setStatus(Status.COMPLETED.toString());
        mailSender.sendMail(project, comments, email);
        log.debug("Ukończono projekt i wysłano maila:", project);
    }

    public List<Project> findAllByStatusAndEngineerId(String status, long id) {
        return projectRepository.findAllByStatusAndEngineerId(status, id);
    }

    public List<Project> findAllByTwoStatusAndManagerId(long id, String status, String statusOptional) {
        return projectRepository.findAllByTwoStatusAndManagerId(id, status, statusOptional);
    }

    public Project findProjectAndFilesById(long id) {
        return projectRepository.findProjectAndFilesById(id);
    }

    public void saveAttachment(Project project, DbFile dbFile) {
        List<DbFile> files = project.getFiles();
        files.add(dbFile);
        projectRepository.save(project);
        log.debug("Przypisano załącznik do projektu:", dbFile, project);
    }

    public void deleteAttachment(Project project, DbFile dbFile) {
        int index = 0;
        List<DbFile> dbFileList = project.getFiles();
        for (int i = 0; i < dbFileList.size(); i++) {
            if (dbFileList.get(i).getId().equals(dbFile.getId())) {
                index = i;
            }
        }
        dbFileList.remove(index);
        log.debug("Usunięto załącznik z projektu:", dbFile, project);
    }

}

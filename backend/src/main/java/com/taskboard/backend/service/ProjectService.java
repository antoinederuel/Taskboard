package com.taskboard.backend.service;

import com.taskboard.backend.model.Project;
import com.taskboard.backend.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(String id) {
        return projectRepository.findById(id);
    }

    public List<Project> getProjectsByOwnerId(String ownerId) {
        return projectRepository. findByOwnerId(ownerId);
    }

    public List<Project> searchProjectsByName(String name) {
        return projectRepository.findByNameContainingIgnoreCase(name);
    }

    public Project updateProject(String id, Project updatedProject) {
        return projectRepository.findById(id)
                .map(existingProject -> {
                    existingProject. setName(updatedProject.getName());
                    existingProject.setDescription(updatedProject.getDescription());
                    existingProject.setColor(updatedProject. getColor());
                    return projectRepository.save(existingProject);
                })
                . orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }

    public void deleteProject(String id) {
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found with id: " + id);
        }
        projectRepository.deleteById(id);
    }
}
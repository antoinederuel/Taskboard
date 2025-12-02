package com. taskboard.backend. model;

import com.taskboard.backend.model.enums.Priority;
import com. taskboard.backend. model.enums. Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok. Data;
import lombok.NoArgsConstructor;
import org.springframework.data. annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org. springframework.data.annotation.LastModifiedDate;
import org. springframework.data.mongodb.core.mapping. Document;

import java.time.LocalDateTime;
import java. util.ArrayList;
import java.util. List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tasks")
public class Task {

    @Id
    private String id;

    private String title;

    private String description;

    @Builder.Default
    private Status status = Status.TODO;

    @Builder.Default
    private Priority priority = Priority. MEDIUM;

    private LocalDateTime dueDate;

    @Builder.Default
    private List<String> labels = new ArrayList<>();

    @Builder.Default
    private List<SubTask> subTasks = new ArrayList<>();

    private String projectId;

    private String assigneeId;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
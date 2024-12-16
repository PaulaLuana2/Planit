package com.planit.tasks.service;

import com.planit.tasks.model.Task;
import com.planit.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Criar uma nova tarefa
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Obter todas as tarefas
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Obter uma tarefa por ID
    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);  // Retorna null se a tarefa não for encontrada
    }

    // Atualizar uma tarefa existente
    public Task updateTask(Long id, Task task) {
        if (taskRepository.existsById(id)) {
            task.setId(id);
            return taskRepository.save(task);
        }
        return null;  // Retorna null se a tarefa não for encontrada
    }

    // Deletar uma tarefa
    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;  // Retorna false se a tarefa não for encontrada
    }
}


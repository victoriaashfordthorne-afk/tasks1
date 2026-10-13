package MbemX.example.secondprojectmbemx.Service;



import MbemX.example.secondprojectmbemx.Model.Task;
import MbemX.example.secondprojectmbemx.Model.TaskRequest;
import MbemX.example.secondprojectmbemx.Repository.TaskRepository;
import MbemX.example.secondprojectmbemx.TaskNotFoundException.TaskNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Task findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task create(TaskRequest request) {
        Task task = new Task();
        apply(task, request);
        return repository.save(task);
    }

    public Task update(Long id, TaskRequest request) {
        Task task = findById(id);
        apply(task, request);
        return task;
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        repository.deleteById(id);
    }

    private void apply(Task task, TaskRequest request) {
        task.setTitle(request.title().trim());
        task.setDescription(request.description());
        if (request.done() != null) {
            task.setDone(request.done());
        }
    }
}

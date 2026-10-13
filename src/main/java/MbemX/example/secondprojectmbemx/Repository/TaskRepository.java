package MbemX.example.secondprojectmbemx.Repository;

import MbemX.example.secondprojectmbemx.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository  extends JpaRepository<Task,Long> {
}

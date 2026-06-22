package task_tracker_cli;

import java.util.ArrayList;
import java.util.List;

public class TaskTracker {
	private ArrayList<Task> tasks = new ArrayList<>();
	
	public TaskTracker(List<Task> tasks) {
	    this.tasks = new ArrayList<>(tasks);
	}
	
	public TaskTracker() {
	    this.tasks = new ArrayList<>();
	}

	public void addTask(String description) {
		int id = generateNextId();

		if (description == null || description.isBlank()) {
			throw new IllegalArgumentException("Description cannot be emtpy");
		}

		Task task = new Task(id, description);

		tasks.add(task);
	}

	public void deleteTask(int id) {

		Task task = findById(id);

		if (task == null) {
			System.out.print("Task not found");
			return;
		}

		tasks.remove(task);
	}

	public void updateTask(int id, String description) {
		Task task = findById(id);

		if (description == null || description.isBlank()) {
			throw new IllegalArgumentException("Description cannot be emtpy");
		}

		if (task == null) {
			System.out.println("Task not found");
			return;
		}

		task.setDescription(description);
	}
	
	public void setTasks(List<Task> tasks) {
	    this.tasks = new ArrayList<>(tasks);
	}

	private void changeStatus(int id, TaskStatus status) {
		Task task = findById(id);

		if (task == null) {
			System.out.println("Task not found");
			return;
		}

		task.setStatus(status);
	}

	public void markInProgress(int id) {
		changeStatus(id, TaskStatus.IN_PROGRESS);
	}

	public void markDone(int id) {
		changeStatus(id, TaskStatus.DONE);
	}

	public ArrayList<Task> getAllTasks() {
		return new ArrayList<>(tasks);
	}

	public void listByStatus(TaskStatus status) {
		for (Task task : tasks) {
			if (task.getStatus() == status) {
				System.out.println(task);
			}
		}
	}

	private Task findById(int id) {

		for (Task task : tasks) {
			if (task.getId() == id) {
				return task;
			}
		}

		return null;
	}

	private int generateNextId() {
		int maxId = 0;

		for (Task task : tasks) {
			if (task.getId() > maxId) {
				maxId = task.getId();
			}
		}

		return maxId + 1;
	}
}

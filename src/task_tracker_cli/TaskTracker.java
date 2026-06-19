package task_tracker_cli;

import java.util.ArrayList;

public class TaskTracker {
	private ArrayList<Task> tasks = new ArrayList<>();

	public TaskTracker() {

	}

	public void addTask(String description) {
		int id = generateNextId();

		Task task = new Task(id, description);

		tasks.add(task);
	}

	public void deleteTask(int id) {
		Task task = findById(id);
		
		if(task == null) {
			System.out.print("Task not found");
			return;
		}
		
		tasks.remove(task);
	}

	public void updateTask(int id, String description) {

	}

	public void markInProgress(int id) {

	}

	public void markDone(int id) {

	}

	public ArrayList<Task> getAllTasks() {
		return tasks;
	}

	public void listByStatus(TaskStatus status) {

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

package task_tracker_cli;

public class TaskTrackerMain {
	public static void main(String[] args) {

		TaskTracker tracker = new TaskTracker();

		if (args.length < 2) {
			System.out.println("Missing arguments");
			return;
		}

		String command = args[0];

		switch (command) {

		case "add":
			String description = args[1];
			tracker.addTask(description);
			System.out.println("Task added successfully");
			break;

		case "delete":
			int id = Integer.parseInt(args[1]);
			tracker.deleteTask(id);
			System.out.println("Task deleted successfully");
			break;

		case "update":
			int updateId = Integer.parseInt(args[1]);
			String updateDescription = args[2];
			tracker.updateTask(updateId, updateDescription);
			break;

		case "mark-in-progress":
			int id1 = Integer.parseInt(args[1]);
			tracker.markInProgress(id1);
			break;

		case "mark-done":
			int id2 = Integer.parseInt(args[1]);
			tracker.markDone(id2);
			break;

		case "list":
			if (args.length == 1) {
				for(Task task : tracker.getAllTasks()) {
					System.out.println(task);
				}
			} else {
				String status = args[1];

				switch (status) {

				case "done":
					tracker.listByStatus(TaskStatus.DONE);
					break;

				case "todo":
					tracker.listByStatus(TaskStatus.TODO);
					break;

				case "in-progress":
					tracker.listByStatus(TaskStatus.IN_PROGRESS);
					break;
				}
			}
		}
	}
}

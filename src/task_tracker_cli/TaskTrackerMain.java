package task_tracker_cli;

public class TaskTrackerMain {

	public static void main(String[] args) {

		TaskStorage storage = new TaskStorage();
		storage.initializeFile();
		TaskTracker tracker = new TaskTracker(storage.loadTasks());

		if (args.length == 0) {
			printUsage();
			return;
		}

		String command = args[0];

		switch (command) {

		case "add":
			if (args.length < 2) {
				System.out.println("Description missing");
				return;
			}

			tracker.addTask(args[1]);
			System.out.println("Task added");
			break;

		case "delete":
			if (args.length < 2) {
				System.out.println("ID missing");
				return;
			}

			tracker.deleteTask(Integer.parseInt(args[1]));
			System.out.println("Task deleted");
			break;

		case "update":
			if (args.length < 3) {
				System.out.println("Usage: update <id> <description>");
				return;
			}

			tracker.updateTask(Integer.parseInt(args[1]), args[2]);
			break;

		case "mark-in-progress":
			tracker.markInProgress(Integer.parseInt(args[1]));
			break;

		case "mark-done":
			tracker.markDone(Integer.parseInt(args[1]));
			break;

		case "list":

			if (args.length == 1) {
				tracker.getAllTasks().forEach(System.out::println);
			} else {
				switch (args[1]) {
				case "done":
					tracker.listByStatus(TaskStatus.DONE);
					break;

				case "todo":
					tracker.listByStatus(TaskStatus.TODO);
					break;

				case "in-progress":
					tracker.listByStatus(TaskStatus.IN_PROGRESS);
					break;

				default:
					System.out.println("Unknown status");
				}
			}
			break;

		default:
			System.out.println("Unknown command");
			printUsage();
		}
		storage.saveTasks(tracker.getAllTasks());
	}

	private static void printUsage() {
		System.out.println("""
				    Commands:
				    task-cli add "description"
				    task-cli update <id> <description>
				    task-cli delete <id>
				    task-cli mark-in-progress <id>
				    task-cli mark-done <id>
				    task-cli list [done|todo|in-progress]
				""");
	}
}
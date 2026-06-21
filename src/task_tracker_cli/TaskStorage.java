package task_tracker_cli;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TaskStorage {
	private static final Path FILE_PATH = Path.of("tasks.json");

	public void initializeFile() {
		try {

			if (!Files.exists(FILE_PATH)) {

				Files.createFile(FILE_PATH);

				Files.writeString(FILE_PATH, "[]");

				System.out.println("tasks.json created.");
			}

		} catch (IOException e) {

			System.out.println("Error while creating tasks.json");
			e.printStackTrace();

		}
	}
}

package task_tracker_cli;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

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

	public void saveTasks(List<Task> tasks) {
		StringBuilder json = new StringBuilder();

		json.append("[\n");

		for (int i = 0; i < tasks.size(); i++) {
			Task task = tasks.get(i);
			json.append("	{\n");
			json.append("    \"id\": ").append(task.getId()).append(",\n");
			json.append("    \"description\": \"").append(task.getDescription()).append("\",\n");
			json.append("    \"status\": \"").append(task.getStatus()).append("\",\n");
			json.append("	 \"createdAt\": \"").append(task.getCreatedAt()).append("\",\n");
			json.append("	 \"updatedAt\": \"").append(task.getUpdatedAt()).append("\"\n");
			json.append("  }");

			if (i < tasks.size() - 1) {
				json.append(",\n");
			}

			json.append("\n");
		}

		json.append("]");

		try {
			Files.writeString(FILE_PATH, json.toString());
		} catch (IOException e) {
			System.out.println("Error saving tasks");
		}

	}

	/*
	 * public List<Task> loadTasks() {
	 * 
	 * List<Task> tasks = new ArrayList<>();
	 * 
	 * try { String json = Files.readString(FILE_PATH).trim();
	 * 
	 * if (json.equals("[]") || json.isEmpty()) { return tasks; }
	 * 
	 * json = json.substring(1, json.length() - 1);
	 * 
	 * String[] items = json.split("\\},\\s*\\{");
	 * 
	 * for (String item : items) {
	 * 
	 * item = item.replace("{", "").replace("}", "").trim();
	 * 
	 * int id = Integer.parseInt(extract(item, "id")); String description =
	 * extract(item, "description"); TaskStatus status =
	 * TaskStatus.valueOf(extract(item, "status"));
	 * 
	 * LocalDateTime createdAt = LocalDateTime.parse(extract(item, "createdAt"));
	 * 
	 * LocalDateTime updatedAt = LocalDateTime.parse(extract(item, "updatedAt"));
	 * 
	 * Task task = new Task(id, description, status, createdAt, updatedAt);
	 * 
	 * tasks.add(task); }
	 * 
	 * } catch (IOException e) { System.out.println("Error reading tasks file"); }
	 * 
	 * return tasks; }
	 * 
	 * private String extract(String item, String key) {
	 * 
	 * String search = "\"" + key + "\":";
	 * 
	 * int start = item.indexOf(search); if (start == -1) return "";
	 * 
	 * start += search.length();
	 * 
	 * int end = item.indexOf(",", start); if (end == -1) end = item.length();
	 * 
	 * String value = item.substring(start, end).trim();
	 * 
	 * value = value.replace("\"", "");
	 * 
	 * return value; }
	 */

	public List<Task> loadTasks() {

		try {

			if (!Files.exists(FILE_PATH)) {
				return new ArrayList<>();
			}

			String json = Files.readString(FILE_PATH);

			if (json.isBlank() || json.equals("[]")) {
				return new ArrayList<>();
			}

			// i can do later Parsing...

			return new ArrayList<>();

		} catch (IOException e) {
			System.out.println("Error reading tasks file");
			return new ArrayList<>();
		}
	}
}

package task_tracker_cli;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
	private int id;
	private String description;
	private TaskStatus status;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

	public Task(int id, String description) {
		this.id = id;
		this.description = description;
		this.status = TaskStatus.TODO;

		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

	public Task(int id, String description, TaskStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
	    this.description = description;
	    this.status = status;
	    this.createdAt = createdAt;
	    this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String newDescription) {
		if (newDescription == null || newDescription.isBlank()) {
			throw new IllegalArgumentException("Description cannot be emtpy");
		}
		this.description = newDescription;
		this.updatedAt = LocalDateTime.now();
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		if (status == null) {
			throw new IllegalArgumentException("Status cannot be null");
		}
		this.status = status;
		this.updatedAt = LocalDateTime.now();
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public String getCreatedAtFormatted() {
		return createdAt.format(FORMATTER);
	}

	public String getUpdatedAtFormatted() {
		return updatedAt.format(FORMATTER);
	}

	@Override
	public String toString() {
		return "Task " + id + "\n------------------------" + "\nDescription: " + description + "\nStatus: " + status
				+ "\nCreated at: " + getCreatedAtFormatted() + "\nUpdated at: " + getUpdatedAtFormatted() + "\n";
	}
}

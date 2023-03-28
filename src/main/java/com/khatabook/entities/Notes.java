package com.khatabook.entities;

import java.time.LocalDateTime;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Notes {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(columnDefinition = "varchar(255)", nullable=false)
	private String title;
	
	@Column(columnDefinition = "varchar(255)", nullable=false)
	private String description;
	
	@Column(columnDefinition = "varchar(255) default 'General'")
	private String tag;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean important;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean completed;
	
	@Column (columnDefinition = "timestamp default current_timestamp" )
	private LocalDateTime date;
	
	@ManyToOne( optional = false)
	@JoinColumn(name = "user", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Boolean getImportant() {
		return important;
	}

	public void setImportant(Boolean important) {
		this.important = important;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Notes(Long id, String title, String description, String tag, Boolean important, Boolean completed,
		LocalDateTime date, User user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.tag = tag;
		this.important = important;
		this.completed = completed;
		this.date = date;
		this.user = user;
	}

	public Notes() {
		super();
	}
}

package com.springboot.rest.service.notes.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "CM_CUSTOMER_NOTE")
public class NoteVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String createNotesFor;
	private String type;
	private String AccessLevel;
	private String breifDescription;
	private String noteText;
	@Lob
	private byte[] data;

	@CreationTimestamp
	@Column(name = "Created_At")
	private Date createdAt;

	@UpdateTimestamp
	@Column(name = "Updated_At")
	private Date updatedAt;

	public NoteVO(Long id, String createNotesFor, String type, String accessLevel, String breifDescription,
			String noteText, byte[] data) {
		super();
		this.id = id;
		this.createNotesFor = createNotesFor;
		this.type = type;
		this.AccessLevel = accessLevel;
		this.breifDescription = breifDescription;
		this.noteText = noteText;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateNotesFor() {
		return createNotesFor;
	}

	public void setCreateNotesFor(String createNotesFor) {
		this.createNotesFor = createNotesFor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccessLevel() {
		return AccessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		AccessLevel = accessLevel;
	}

	public String getBreifDescription() {
		return breifDescription;
	}

	public void setBreifDescription(String breifDescription) {
		this.breifDescription = breifDescription;
	}

	public String getNoteText() {
		return noteText;
	}

	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "NoteVO [id=" + id + ", createNotesFor=" + createNotesFor + ", type=" + type + ", AccessLevel="
				+ AccessLevel + ", breifDescription=" + breifDescription + ", noteText=" + noteText + ", data="
				+ Arrays.toString(data) + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}

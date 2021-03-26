package com.test.postoffice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "processed_post_package")
public class ProcessedPostPackage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "PostPackage.id")
	private PostPackage postPackage;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EStatus status;
	
	@NotNull
	private Date date;
	
	@OneToOne
	@JoinColumn(name = "current_post_office_id", referencedColumnName = "id")
	private PostOffice currentPostOffice;
	
	public ProcessedPostPackage() {
	}

	public ProcessedPostPackage(PostPackage postPackage, EStatus status, @NotNull Date date,
			PostOffice currentPostOffice) {
		this.postPackage = postPackage;
		this.status = status;
		this.date = date;
		this.currentPostOffice = currentPostOffice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PostPackage getPostPackage() {
		return postPackage;
	}

	public void setPostPackage(PostPackage postPackage) {
		this.postPackage = postPackage;
	}

	public EStatus getStatus() {
		return status;
	}

	public void setStatus(EStatus status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PostOffice getCurrentPostOffice() {
		return currentPostOffice;
	}

	public void setCurrentPostOffice(PostOffice currentPostOffice) {
		this.currentPostOffice = currentPostOffice;
	}

	@Override
	public String toString() {
		return "ProcessedPostPackage [id=" + id + ", postPackage=" + postPackage + ", status=" + status + ", date="
				+ date + ", currentPostOffice=" + currentPostOffice + "]";
	}
}

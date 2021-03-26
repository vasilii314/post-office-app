package com.test.postoffice.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "post_package")
public class PostPackage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private EPostPackageType type;
	
	@OneToOne
	@JoinColumn(name = "dst_post_office_id", referencedColumnName = "id")
	private PostOffice dstPostOffice;
	
	@NotBlank
	@Size(max = 150)
	private String recipientAddress;
	
	@NotBlank
	@Size(max = 120)
	private String recipientName;
	
	@OneToMany(mappedBy = "postPackage")
	private List<ProcessedPostPackage> history;
	
	public PostPackage() {
	}

	public PostPackage(EPostPackageType type, PostOffice dstPostOffice,
			@NotBlank @Size(max = 150) String recipientAddress, @NotBlank @Size(max = 120) String recipientName) {
		this.type = type;
		this.dstPostOffice = dstPostOffice;
		this.recipientAddress = recipientAddress;
		this.recipientName = recipientName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EPostPackageType getType() {
		return type;
	}

	public void setType(EPostPackageType type) {
		this.type = type;
	}

	public PostOffice getDstPostOffice() {
		return dstPostOffice;
	}

	public void setDstPostOffice(PostOffice dstPostOffice) {
		this.dstPostOffice = dstPostOffice;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	
	public List<ProcessedPostPackage> getHistory() {
		return history;
	}

	public void setHistory(List<ProcessedPostPackage> history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "PostPackage [id=" + id + ", type=" + type + ", dstPostOffice=" + dstPostOffice + ", recipientAddress="
				+ recipientAddress + ", recipientName=" + recipientName + "]";
	}
}

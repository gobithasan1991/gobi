package com.basic.persitance.model.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.basic.extensible.CurrentStatus;
import com.basic.extensible.RecordStatus;
import com.basic.persitance.model.security.User;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class Default  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@CreatedBy
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false)
	private User createdBy;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "TIMESTAMP",updatable = false)
	private Date createdDate;
	
	@LastModifiedBy
	@ManyToOne(fetch = FetchType.LAZY)
	private User modifiedBy;
 
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP) 
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date modifiedDate;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('ACTIVE', 'INACTIVE', 'DELETED', 'HOLDED', 'LOCKED', 'BLOCKED') DEFAULT 'ACTIVE'",insertable = false,nullable = false)
	private CurrentStatus currentStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('CREATED','UPDATED','DELETED') DEFAULT 'CREATED'",insertable = false,nullable = false)
	private RecordStatus recordStatus;

	public Default() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public CurrentStatus getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(CurrentStatus currentStatus) {
		this.currentStatus = currentStatus;
	}

	public RecordStatus getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(RecordStatus recordStatus) {
		this.recordStatus = recordStatus;
	}
	
}

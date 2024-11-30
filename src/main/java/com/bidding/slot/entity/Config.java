package com.bidding.slot.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "Config")
public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "config_config_id_seq")
    @SequenceGenerator(name = "config_config_id_seq", sequenceName = "config_config_id_seq", allocationSize = 1)
    @Column(name = "config_id")
    private Long configId;

    @Column(name = "config_name", nullable = false)
    private String configName;

    @Column(name = "config_code", nullable = false)
    private String configCode;

    @Column(name = "config_desc")
    private String configDesc;

    @Column(name = "config_value", nullable = false)
    private String configValue;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    

    public Config(Long configId, String configName, String configCode, String configDesc, String configValue,
			LocalDateTime updatedAt) {
		super();
		this.configId = configId;
		this.configName = configName;
		this.configCode = configCode;
		this.configDesc = configDesc;
		this.configValue = configValue;
		this.updatedAt = updatedAt;
	}



	public Long getConfigId() {
		return configId;
	}



	public void setConfigId(Long configId) {
		this.configId = configId;
	}



	public String getConfigName() {
		return configName;
	}



	public void setConfigName(String configName) {
		this.configName = configName;
	}



	public String getConfigCode() {
		return configCode;
	}



	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	}



	public String getConfigDesc() {
		return configDesc;
	}



	public void setConfigDesc(String configDesc) {
		this.configDesc = configDesc;
	}



	public String getConfigValue() {
		return configValue;
	}



	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}



	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Config() {
		super();
	}

	@PrePersist
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }



	@Override
	public String toString() {
		return "Config [configId=" + configId + ", configName=" + configName + ", configCode=" + configCode
				+ ", configDesc=" + configDesc + ", configValue=" + configValue + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
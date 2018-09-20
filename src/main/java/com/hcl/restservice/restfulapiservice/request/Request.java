package com.hcl.restservice.restfulapiservice.request;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;


@Entity
public class Request {

	@Id
	@GeneratedValue
	private Integer id;

	private Date requestDate;

	private String userName;

	private String clientID;
	private String clientSecret;

	@Size(min = 4, message = "cluster name should have more than 4 characters")
	private String clusterName;

	@Size(min = 4, message = "dns prefix should have more than 4 characters")
	private String dnsPrefix;

	@Size(min = 5, message = "Resource group should have more than 4 characters")
	private String resourceGroupName;

	protected Request() {

	}

	public Request(Integer id, Date requestDate, String userName, String clientID, String clientSecret,
			@Size(min = 4, message = "cluster name should have more than 4 characters") String clusterName,
			@Size(min = 4, message = "dns prefix should have more than 4 characters") String dnsPrefix,
			@Size(min = 5, message = "Resource group should have more than 4 characters") String resourceGroupName) {
		super();
		this.id = id;
		this.requestDate = requestDate;
		this.userName = userName;
		this.clientID = clientID;
		this.clientSecret = clientSecret;
		this.clusterName = clusterName;
		this.dnsPrefix = dnsPrefix;
		this.resourceGroupName = resourceGroupName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public String getDnsPrefix() {
		return dnsPrefix;
	}

	public void setDnsPrefix(String dnsPrefix) {
		this.dnsPrefix = dnsPrefix;
	}

	public String getResourceGroupName() {
		return resourceGroupName;
	}

	public void setResourceGroupName(String resourceGroupName) {
		this.resourceGroupName = resourceGroupName;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", requestDate=" + requestDate + ", userName=" + userName + ", clientID="
				+ clientID + ", clientSecret=" + clientSecret + ", clusterName=" + clusterName + ", dnsPrefix="
				+ dnsPrefix + ", resourceGroupName=" + resourceGroupName + "]";
	}

	

}

package com.shri.dumpdata.document;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Data {

	@Id
	@JsonIgnore
	private String id;

	private Date createdAt;

	private Object data;

	public static class DataBuilder {
		public static Data build(Object dataObject) {
			Data data = new Data();
			data.setData(dataObject);
			return data;
		}
	}

	public Data() {
		this.createdAt = new Date();
	}

	public String getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Object getData() {
		return data;
	}

	private void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", createdAt=" + createdAt + ", data=" + data + "]";
	}

}

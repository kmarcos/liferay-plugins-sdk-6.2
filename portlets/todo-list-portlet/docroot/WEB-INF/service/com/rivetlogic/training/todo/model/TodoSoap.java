/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.rivetlogic.training.todo.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rivetlogic.training.todo.service.http.TodoServiceSoap}.
 *
 * @author rivetlogic
 * @see com.rivetlogic.training.todo.service.http.TodoServiceSoap
 * @generated
 */
public class TodoSoap implements Serializable {
	public static TodoSoap toSoapModel(Todo model) {
		TodoSoap soapModel = new TodoSoap();

		soapModel.setTodoId(model.getTodoId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTaskDescription(model.getTaskDescription());
		soapModel.setFinished(model.getFinished());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setFinishedDate(model.getFinishedDate());

		return soapModel;
	}

	public static TodoSoap[] toSoapModels(Todo[] models) {
		TodoSoap[] soapModels = new TodoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TodoSoap[][] toSoapModels(Todo[][] models) {
		TodoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TodoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TodoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TodoSoap[] toSoapModels(List<Todo> models) {
		List<TodoSoap> soapModels = new ArrayList<TodoSoap>(models.size());

		for (Todo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TodoSoap[soapModels.size()]);
	}

	public TodoSoap() {
	}

	public long getPrimaryKey() {
		return _todoId;
	}

	public void setPrimaryKey(long pk) {
		setTodoId(pk);
	}

	public long getTodoId() {
		return _todoId;
	}

	public void setTodoId(long todoId) {
		_todoId = todoId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getTaskDescription() {
		return _taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		_taskDescription = taskDescription;
	}

	public boolean getFinished() {
		return _finished;
	}

	public boolean isFinished() {
		return _finished;
	}

	public void setFinished(boolean finished) {
		_finished = finished;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getFinishedDate() {
		return _finishedDate;
	}

	public void setFinishedDate(Date finishedDate) {
		_finishedDate = finishedDate;
	}

	private long _todoId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _taskDescription;
	private boolean _finished;
	private Date _createdDate;
	private Date _finishedDate;
}
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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rivetlogic.training.todo.service.ClpSerializer;
import com.rivetlogic.training.todo.service.TodoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rivetlogic
 */
public class TodoClp extends BaseModelImpl<Todo> implements Todo {
	public TodoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Todo.class;
	}

	@Override
	public String getModelClassName() {
		return Todo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _todoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTodoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _todoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("todoId", getTodoId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("taskDescription", getTaskDescription());
		attributes.put("finished", getFinished());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("finishedDate", getFinishedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long todoId = (Long)attributes.get("todoId");

		if (todoId != null) {
			setTodoId(todoId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String taskDescription = (String)attributes.get("taskDescription");

		if (taskDescription != null) {
			setTaskDescription(taskDescription);
		}

		Boolean finished = (Boolean)attributes.get("finished");

		if (finished != null) {
			setFinished(finished);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date finishedDate = (Date)attributes.get("finishedDate");

		if (finishedDate != null) {
			setFinishedDate(finishedDate);
		}
	}

	@Override
	public long getTodoId() {
		return _todoId;
	}

	@Override
	public void setTodoId(long todoId) {
		_todoId = todoId;

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setTodoId", long.class);

				method.invoke(_todoRemoteModel, todoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_todoRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_todoRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_todoRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getTaskDescription() {
		return _taskDescription;
	}

	@Override
	public void setTaskDescription(String taskDescription) {
		_taskDescription = taskDescription;

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setTaskDescription",
						String.class);

				method.invoke(_todoRemoteModel, taskDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getFinished() {
		return _finished;
	}

	@Override
	public boolean isFinished() {
		return _finished;
	}

	@Override
	public void setFinished(boolean finished) {
		_finished = finished;

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setFinished", boolean.class);

				method.invoke(_todoRemoteModel, finished);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_todoRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getFinishedDate() {
		return _finishedDate;
	}

	@Override
	public void setFinishedDate(Date finishedDate) {
		_finishedDate = finishedDate;

		if (_todoRemoteModel != null) {
			try {
				Class<?> clazz = _todoRemoteModel.getClass();

				Method method = clazz.getMethod("setFinishedDate", Date.class);

				method.invoke(_todoRemoteModel, finishedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTodoRemoteModel() {
		return _todoRemoteModel;
	}

	public void setTodoRemoteModel(BaseModel<?> todoRemoteModel) {
		_todoRemoteModel = todoRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _todoRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_todoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TodoLocalServiceUtil.addTodo(this);
		}
		else {
			TodoLocalServiceUtil.updateTodo(this);
		}
	}

	@Override
	public Todo toEscapedModel() {
		return (Todo)ProxyUtil.newProxyInstance(Todo.class.getClassLoader(),
			new Class[] { Todo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TodoClp clone = new TodoClp();

		clone.setTodoId(getTodoId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setTaskDescription(getTaskDescription());
		clone.setFinished(getFinished());
		clone.setCreatedDate(getCreatedDate());
		clone.setFinishedDate(getFinishedDate());

		return clone;
	}

	@Override
	public int compareTo(Todo todo) {
		int value = 0;

		value = DateUtil.compareTo(getCreatedDate(), todo.getCreatedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TodoClp)) {
			return false;
		}

		TodoClp todo = (TodoClp)obj;

		long primaryKey = todo.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{todoId=");
		sb.append(getTodoId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", taskDescription=");
		sb.append(getTaskDescription());
		sb.append(", finished=");
		sb.append(getFinished());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", finishedDate=");
		sb.append(getFinishedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.training.todo.model.Todo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>todoId</column-name><column-value><![CDATA[");
		sb.append(getTodoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taskDescription</column-name><column-value><![CDATA[");
		sb.append(getTaskDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finished</column-name><column-value><![CDATA[");
		sb.append(getFinished());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finishedDate</column-name><column-value><![CDATA[");
		sb.append(getFinishedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _todoId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _taskDescription;
	private boolean _finished;
	private Date _createdDate;
	private Date _finishedDate;
	private BaseModel<?> _todoRemoteModel;
}
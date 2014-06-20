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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Todo}.
 * </p>
 *
 * @author rivetlogic
 * @see Todo
 * @generated
 */
public class TodoWrapper implements Todo, ModelWrapper<Todo> {
	public TodoWrapper(Todo todo) {
		_todo = todo;
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

	/**
	* Returns the primary key of this todo.
	*
	* @return the primary key of this todo
	*/
	@Override
	public long getPrimaryKey() {
		return _todo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this todo.
	*
	* @param primaryKey the primary key of this todo
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_todo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the todo ID of this todo.
	*
	* @return the todo ID of this todo
	*/
	@Override
	public long getTodoId() {
		return _todo.getTodoId();
	}

	/**
	* Sets the todo ID of this todo.
	*
	* @param todoId the todo ID of this todo
	*/
	@Override
	public void setTodoId(long todoId) {
		_todo.setTodoId(todoId);
	}

	/**
	* Returns the company ID of this todo.
	*
	* @return the company ID of this todo
	*/
	@Override
	public long getCompanyId() {
		return _todo.getCompanyId();
	}

	/**
	* Sets the company ID of this todo.
	*
	* @param companyId the company ID of this todo
	*/
	@Override
	public void setCompanyId(long companyId) {
		_todo.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this todo.
	*
	* @return the group ID of this todo
	*/
	@Override
	public long getGroupId() {
		return _todo.getGroupId();
	}

	/**
	* Sets the group ID of this todo.
	*
	* @param groupId the group ID of this todo
	*/
	@Override
	public void setGroupId(long groupId) {
		_todo.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this todo.
	*
	* @return the user ID of this todo
	*/
	@Override
	public long getUserId() {
		return _todo.getUserId();
	}

	/**
	* Sets the user ID of this todo.
	*
	* @param userId the user ID of this todo
	*/
	@Override
	public void setUserId(long userId) {
		_todo.setUserId(userId);
	}

	/**
	* Returns the user uuid of this todo.
	*
	* @return the user uuid of this todo
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _todo.getUserUuid();
	}

	/**
	* Sets the user uuid of this todo.
	*
	* @param userUuid the user uuid of this todo
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_todo.setUserUuid(userUuid);
	}

	/**
	* Returns the task description of this todo.
	*
	* @return the task description of this todo
	*/
	@Override
	public java.lang.String getTaskDescription() {
		return _todo.getTaskDescription();
	}

	/**
	* Sets the task description of this todo.
	*
	* @param taskDescription the task description of this todo
	*/
	@Override
	public void setTaskDescription(java.lang.String taskDescription) {
		_todo.setTaskDescription(taskDescription);
	}

	/**
	* Returns the finished of this todo.
	*
	* @return the finished of this todo
	*/
	@Override
	public boolean getFinished() {
		return _todo.getFinished();
	}

	/**
	* Returns <code>true</code> if this todo is finished.
	*
	* @return <code>true</code> if this todo is finished; <code>false</code> otherwise
	*/
	@Override
	public boolean isFinished() {
		return _todo.isFinished();
	}

	/**
	* Sets whether this todo is finished.
	*
	* @param finished the finished of this todo
	*/
	@Override
	public void setFinished(boolean finished) {
		_todo.setFinished(finished);
	}

	/**
	* Returns the created date of this todo.
	*
	* @return the created date of this todo
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _todo.getCreatedDate();
	}

	/**
	* Sets the created date of this todo.
	*
	* @param createdDate the created date of this todo
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_todo.setCreatedDate(createdDate);
	}

	/**
	* Returns the finished date of this todo.
	*
	* @return the finished date of this todo
	*/
	@Override
	public java.util.Date getFinishedDate() {
		return _todo.getFinishedDate();
	}

	/**
	* Sets the finished date of this todo.
	*
	* @param finishedDate the finished date of this todo
	*/
	@Override
	public void setFinishedDate(java.util.Date finishedDate) {
		_todo.setFinishedDate(finishedDate);
	}

	@Override
	public boolean isNew() {
		return _todo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_todo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _todo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_todo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _todo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _todo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_todo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _todo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_todo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_todo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_todo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TodoWrapper((Todo)_todo.clone());
	}

	@Override
	public int compareTo(com.rivetlogic.training.todo.model.Todo todo) {
		return _todo.compareTo(todo);
	}

	@Override
	public int hashCode() {
		return _todo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.training.todo.model.Todo> toCacheModel() {
		return _todo.toCacheModel();
	}

	@Override
	public com.rivetlogic.training.todo.model.Todo toEscapedModel() {
		return new TodoWrapper(_todo.toEscapedModel());
	}

	@Override
	public com.rivetlogic.training.todo.model.Todo toUnescapedModel() {
		return new TodoWrapper(_todo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _todo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _todo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_todo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TodoWrapper)) {
			return false;
		}

		TodoWrapper todoWrapper = (TodoWrapper)obj;

		if (Validator.equals(_todo, todoWrapper._todo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Todo getWrappedTodo() {
		return _todo;
	}

	@Override
	public Todo getWrappedModel() {
		return _todo;
	}

	@Override
	public void resetOriginalValues() {
		_todo.resetOriginalValues();
	}

	private Todo _todo;
}
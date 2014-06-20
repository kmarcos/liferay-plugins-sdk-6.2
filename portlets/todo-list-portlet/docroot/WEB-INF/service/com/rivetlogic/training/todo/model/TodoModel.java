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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Todo service. Represents a row in the &quot;training_Todo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rivetlogic.training.todo.model.impl.TodoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rivetlogic.training.todo.model.impl.TodoImpl}.
 * </p>
 *
 * @author rivetlogic
 * @see Todo
 * @see com.rivetlogic.training.todo.model.impl.TodoImpl
 * @see com.rivetlogic.training.todo.model.impl.TodoModelImpl
 * @generated
 */
public interface TodoModel extends BaseModel<Todo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a todo model instance should use the {@link Todo} interface instead.
	 */

	/**
	 * Returns the primary key of this todo.
	 *
	 * @return the primary key of this todo
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this todo.
	 *
	 * @param primaryKey the primary key of this todo
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the todo ID of this todo.
	 *
	 * @return the todo ID of this todo
	 */
	public long getTodoId();

	/**
	 * Sets the todo ID of this todo.
	 *
	 * @param todoId the todo ID of this todo
	 */
	public void setTodoId(long todoId);

	/**
	 * Returns the company ID of this todo.
	 *
	 * @return the company ID of this todo
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this todo.
	 *
	 * @param companyId the company ID of this todo
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this todo.
	 *
	 * @return the group ID of this todo
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this todo.
	 *
	 * @param groupId the group ID of this todo
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this todo.
	 *
	 * @return the user ID of this todo
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this todo.
	 *
	 * @param userId the user ID of this todo
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this todo.
	 *
	 * @return the user uuid of this todo
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this todo.
	 *
	 * @param userUuid the user uuid of this todo
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the task description of this todo.
	 *
	 * @return the task description of this todo
	 */
	@AutoEscape
	public String getTaskDescription();

	/**
	 * Sets the task description of this todo.
	 *
	 * @param taskDescription the task description of this todo
	 */
	public void setTaskDescription(String taskDescription);

	/**
	 * Returns the finished of this todo.
	 *
	 * @return the finished of this todo
	 */
	public boolean getFinished();

	/**
	 * Returns <code>true</code> if this todo is finished.
	 *
	 * @return <code>true</code> if this todo is finished; <code>false</code> otherwise
	 */
	public boolean isFinished();

	/**
	 * Sets whether this todo is finished.
	 *
	 * @param finished the finished of this todo
	 */
	public void setFinished(boolean finished);

	/**
	 * Returns the created date of this todo.
	 *
	 * @return the created date of this todo
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this todo.
	 *
	 * @param createdDate the created date of this todo
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the finished date of this todo.
	 *
	 * @return the finished date of this todo
	 */
	public Date getFinishedDate();

	/**
	 * Sets the finished date of this todo.
	 *
	 * @param finishedDate the finished date of this todo
	 */
	public void setFinishedDate(Date finishedDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Todo todo);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Todo> toCacheModel();

	@Override
	public Todo toEscapedModel();

	@Override
	public Todo toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
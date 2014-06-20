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

package com.rivetlogic.training.todo.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rivetlogic.training.todo.model.Todo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Todo in entity cache.
 *
 * @author rivetlogic
 * @see Todo
 * @generated
 */
public class TodoCacheModel implements CacheModel<Todo>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{todoId=");
		sb.append(todoId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", taskDescription=");
		sb.append(taskDescription);
		sb.append(", finished=");
		sb.append(finished);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", finishedDate=");
		sb.append(finishedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Todo toEntityModel() {
		TodoImpl todoImpl = new TodoImpl();

		todoImpl.setTodoId(todoId);
		todoImpl.setCompanyId(companyId);
		todoImpl.setGroupId(groupId);
		todoImpl.setUserId(userId);

		if (taskDescription == null) {
			todoImpl.setTaskDescription(StringPool.BLANK);
		}
		else {
			todoImpl.setTaskDescription(taskDescription);
		}

		todoImpl.setFinished(finished);

		if (createdDate == Long.MIN_VALUE) {
			todoImpl.setCreatedDate(null);
		}
		else {
			todoImpl.setCreatedDate(new Date(createdDate));
		}

		if (finishedDate == Long.MIN_VALUE) {
			todoImpl.setFinishedDate(null);
		}
		else {
			todoImpl.setFinishedDate(new Date(finishedDate));
		}

		todoImpl.resetOriginalValues();

		return todoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		todoId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		taskDescription = objectInput.readUTF();
		finished = objectInput.readBoolean();
		createdDate = objectInput.readLong();
		finishedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(todoId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (taskDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taskDescription);
		}

		objectOutput.writeBoolean(finished);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(finishedDate);
	}

	public long todoId;
	public long companyId;
	public long groupId;
	public long userId;
	public String taskDescription;
	public boolean finished;
	public long createdDate;
	public long finishedDate;
}
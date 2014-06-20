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

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Todo service. Represents a row in the &quot;training_Todo&quot; database table, with each column mapped to a property of this class.
 *
 * @author rivetlogic
 * @see TodoModel
 * @see com.rivetlogic.training.todo.model.impl.TodoImpl
 * @see com.rivetlogic.training.todo.model.impl.TodoModelImpl
 * @generated
 */
public interface Todo extends TodoModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.rivetlogic.training.todo.model.impl.TodoImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
}
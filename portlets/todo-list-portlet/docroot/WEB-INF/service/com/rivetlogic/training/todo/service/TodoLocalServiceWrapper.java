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

package com.rivetlogic.training.todo.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TodoLocalService}.
 *
 * @author rivetlogic
 * @see TodoLocalService
 * @generated
 */
public class TodoLocalServiceWrapper implements TodoLocalService,
	ServiceWrapper<TodoLocalService> {
	public TodoLocalServiceWrapper(TodoLocalService todoLocalService) {
		_todoLocalService = todoLocalService;
	}

	/**
	* Adds the todo to the database. Also notifies the appropriate model listeners.
	*
	* @param todo the todo
	* @return the todo that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.training.todo.model.Todo addTodo(
		com.rivetlogic.training.todo.model.Todo todo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.addTodo(todo);
	}

	/**
	* Creates a new todo with the primary key. Does not add the todo to the database.
	*
	* @param todoId the primary key for the new todo
	* @return the new todo
	*/
	@Override
	public com.rivetlogic.training.todo.model.Todo createTodo(long todoId) {
		return _todoLocalService.createTodo(todoId);
	}

	/**
	* Deletes the todo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param todoId the primary key of the todo
	* @return the todo that was removed
	* @throws PortalException if a todo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.training.todo.model.Todo deleteTodo(long todoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.deleteTodo(todoId);
	}

	/**
	* Deletes the todo from the database. Also notifies the appropriate model listeners.
	*
	* @param todo the todo
	* @return the todo that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.training.todo.model.Todo deleteTodo(
		com.rivetlogic.training.todo.model.Todo todo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.deleteTodo(todo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _todoLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.training.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.training.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.rivetlogic.training.todo.model.Todo fetchTodo(long todoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.fetchTodo(todoId);
	}

	/**
	* Returns the todo with the primary key.
	*
	* @param todoId the primary key of the todo
	* @return the todo
	* @throws PortalException if a todo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.training.todo.model.Todo getTodo(long todoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.getTodo(todoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the todos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.training.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of todos
	* @param end the upper bound of the range of todos (not inclusive)
	* @return the range of todos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rivetlogic.training.todo.model.Todo> getTodos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.getTodos(start, end);
	}

	/**
	* Returns the number of todos.
	*
	* @return the number of todos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTodosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.getTodosCount();
	}

	/**
	* Updates the todo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param todo the todo
	* @return the todo that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.training.todo.model.Todo updateTodo(
		com.rivetlogic.training.todo.model.Todo todo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.updateTodo(todo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _todoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_todoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _todoLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.rivetlogic.training.todo.model.Todo addTask(
		com.rivetlogic.training.todo.model.Todo todo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.addTask(todo);
	}

	@Override
	public com.rivetlogic.training.todo.model.Todo updateTask(
		com.rivetlogic.training.todo.model.Todo todo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.updateTask(todo);
	}

	@Override
	public java.util.List<com.rivetlogic.training.todo.model.Todo> getTodoListByCompanyGroupAndUser(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.getTodoListByCompanyGroupAndUser(companyId,
			groupId, userId);
	}

	@Override
	public int getTodoListCountByCompanyGroupAndUser(long companyId,
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _todoLocalService.getTodoListCountByCompanyGroupAndUser(companyId,
			groupId, userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TodoLocalService getWrappedTodoLocalService() {
		return _todoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTodoLocalService(TodoLocalService todoLocalService) {
		_todoLocalService = todoLocalService;
	}

	@Override
	public TodoLocalService getWrappedService() {
		return _todoLocalService;
	}

	@Override
	public void setWrappedService(TodoLocalService todoLocalService) {
		_todoLocalService = todoLocalService;
	}

	private TodoLocalService _todoLocalService;
}
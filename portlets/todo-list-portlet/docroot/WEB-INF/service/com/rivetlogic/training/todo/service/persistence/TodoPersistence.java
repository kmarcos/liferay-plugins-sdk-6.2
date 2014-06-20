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

package com.rivetlogic.training.todo.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.rivetlogic.training.todo.model.Todo;

/**
 * The persistence interface for the todo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rivetlogic
 * @see TodoPersistenceImpl
 * @see TodoUtil
 * @generated
 */
public interface TodoPersistence extends BasePersistence<Todo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TodoUtil} to access the todo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the todos where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching todos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.training.todo.model.Todo> findByCompanyId_GroupId_UserId(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the todos where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.training.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of todos
	* @param end the upper bound of the range of todos (not inclusive)
	* @return the range of matching todos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.training.todo.model.Todo> findByCompanyId_GroupId_UserId(
		long companyId, long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the todos where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.training.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of todos
	* @param end the upper bound of the range of todos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching todos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.training.todo.model.Todo> findByCompanyId_GroupId_UserId(
		long companyId, long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first todo in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching todo
	* @throws com.rivetlogic.training.todo.NoSuchTodoException if a matching todo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.training.todo.model.Todo findByCompanyId_GroupId_UserId_First(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.training.todo.NoSuchTodoException;

	/**
	* Returns the first todo in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching todo, or <code>null</code> if a matching todo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.training.todo.model.Todo fetchByCompanyId_GroupId_UserId_First(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last todo in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching todo
	* @throws com.rivetlogic.training.todo.NoSuchTodoException if a matching todo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.training.todo.model.Todo findByCompanyId_GroupId_UserId_Last(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.training.todo.NoSuchTodoException;

	/**
	* Returns the last todo in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching todo, or <code>null</code> if a matching todo could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.training.todo.model.Todo fetchByCompanyId_GroupId_UserId_Last(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the todos before and after the current todo in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param todoId the primary key of the current todo
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next todo
	* @throws com.rivetlogic.training.todo.NoSuchTodoException if a todo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.training.todo.model.Todo[] findByCompanyId_GroupId_UserId_PrevAndNext(
		long todoId, long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.training.todo.NoSuchTodoException;

	/**
	* Returns all the todos that the user has permission to view where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching todos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.training.todo.model.Todo> filterFindByCompanyId_GroupId_UserId(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the todos that the user has permission to view where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.training.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of todos
	* @param end the upper bound of the range of todos (not inclusive)
	* @return the range of matching todos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.training.todo.model.Todo> filterFindByCompanyId_GroupId_UserId(
		long companyId, long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the todos that the user has permissions to view where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.training.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of todos
	* @param end the upper bound of the range of todos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching todos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.training.todo.model.Todo> filterFindByCompanyId_GroupId_UserId(
		long companyId, long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the todos before and after the current todo in the ordered set of todos that the user has permission to view where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param todoId the primary key of the current todo
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next todo
	* @throws com.rivetlogic.training.todo.NoSuchTodoException if a todo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.training.todo.model.Todo[] filterFindByCompanyId_GroupId_UserId_PrevAndNext(
		long todoId, long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.training.todo.NoSuchTodoException;

	/**
	* Removes all the todos where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId_GroupId_UserId(long companyId, long groupId,
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of todos where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching todos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId_GroupId_UserId(long companyId, long groupId,
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of todos that the user has permission to view where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching todos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCompanyId_GroupId_UserId(long companyId,
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the todo in the entity cache if it is enabled.
	*
	* @param todo the todo
	*/
	public void cacheResult(com.rivetlogic.training.todo.model.Todo todo);

	/**
	* Caches the todos in the entity cache if it is enabled.
	*
	* @param todos the todos
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.training.todo.model.Todo> todos);

	/**
	* Creates a new todo with the primary key. Does not add the todo to the database.
	*
	* @param todoId the primary key for the new todo
	* @return the new todo
	*/
	public com.rivetlogic.training.todo.model.Todo create(long todoId);

	/**
	* Removes the todo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param todoId the primary key of the todo
	* @return the todo that was removed
	* @throws com.rivetlogic.training.todo.NoSuchTodoException if a todo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.training.todo.model.Todo remove(long todoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.training.todo.NoSuchTodoException;

	public com.rivetlogic.training.todo.model.Todo updateImpl(
		com.rivetlogic.training.todo.model.Todo todo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the todo with the primary key or throws a {@link com.rivetlogic.training.todo.NoSuchTodoException} if it could not be found.
	*
	* @param todoId the primary key of the todo
	* @return the todo
	* @throws com.rivetlogic.training.todo.NoSuchTodoException if a todo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.training.todo.model.Todo findByPrimaryKey(long todoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.training.todo.NoSuchTodoException;

	/**
	* Returns the todo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param todoId the primary key of the todo
	* @return the todo, or <code>null</code> if a todo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.training.todo.model.Todo fetchByPrimaryKey(
		long todoId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the todos.
	*
	* @return the todos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.training.todo.model.Todo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.training.todo.model.Todo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the todos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.training.todo.model.impl.TodoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of todos
	* @param end the upper bound of the range of todos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of todos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.training.todo.model.Todo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the todos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of todos.
	*
	* @return the number of todos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
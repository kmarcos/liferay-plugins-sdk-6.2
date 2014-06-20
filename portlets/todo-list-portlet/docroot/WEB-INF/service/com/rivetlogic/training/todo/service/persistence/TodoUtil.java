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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rivetlogic.training.todo.model.Todo;

import java.util.List;

/**
 * The persistence utility for the todo service. This utility wraps {@link TodoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rivetlogic
 * @see TodoPersistence
 * @see TodoPersistenceImpl
 * @generated
 */
public class TodoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Todo todo) {
		getPersistence().clearCache(todo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Todo> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Todo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Todo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Todo update(Todo todo) throws SystemException {
		return getPersistence().update(todo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Todo update(Todo todo, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(todo, serviceContext);
	}

	/**
	* Returns all the todos where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching todos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.training.todo.model.Todo> findByCompanyId_GroupId_UserId(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_GroupId_UserId(companyId, groupId, userId);
	}

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
	public static java.util.List<com.rivetlogic.training.todo.model.Todo> findByCompanyId_GroupId_UserId(
		long companyId, long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_GroupId_UserId(companyId, groupId, userId,
			start, end);
	}

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
	public static java.util.List<com.rivetlogic.training.todo.model.Todo> findByCompanyId_GroupId_UserId(
		long companyId, long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_GroupId_UserId(companyId, groupId, userId,
			start, end, orderByComparator);
	}

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
	public static com.rivetlogic.training.todo.model.Todo findByCompanyId_GroupId_UserId_First(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.training.todo.NoSuchTodoException {
		return getPersistence()
				   .findByCompanyId_GroupId_UserId_First(companyId, groupId,
			userId, orderByComparator);
	}

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
	public static com.rivetlogic.training.todo.model.Todo fetchByCompanyId_GroupId_UserId_First(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_GroupId_UserId_First(companyId, groupId,
			userId, orderByComparator);
	}

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
	public static com.rivetlogic.training.todo.model.Todo findByCompanyId_GroupId_UserId_Last(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.training.todo.NoSuchTodoException {
		return getPersistence()
				   .findByCompanyId_GroupId_UserId_Last(companyId, groupId,
			userId, orderByComparator);
	}

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
	public static com.rivetlogic.training.todo.model.Todo fetchByCompanyId_GroupId_UserId_Last(
		long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_GroupId_UserId_Last(companyId, groupId,
			userId, orderByComparator);
	}

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
	public static com.rivetlogic.training.todo.model.Todo[] findByCompanyId_GroupId_UserId_PrevAndNext(
		long todoId, long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.training.todo.NoSuchTodoException {
		return getPersistence()
				   .findByCompanyId_GroupId_UserId_PrevAndNext(todoId,
			companyId, groupId, userId, orderByComparator);
	}

	/**
	* Returns all the todos that the user has permission to view where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching todos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.training.todo.model.Todo> filterFindByCompanyId_GroupId_UserId(
		long companyId, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCompanyId_GroupId_UserId(companyId, groupId,
			userId);
	}

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
	public static java.util.List<com.rivetlogic.training.todo.model.Todo> filterFindByCompanyId_GroupId_UserId(
		long companyId, long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCompanyId_GroupId_UserId(companyId, groupId,
			userId, start, end);
	}

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
	public static java.util.List<com.rivetlogic.training.todo.model.Todo> filterFindByCompanyId_GroupId_UserId(
		long companyId, long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCompanyId_GroupId_UserId(companyId, groupId,
			userId, start, end, orderByComparator);
	}

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
	public static com.rivetlogic.training.todo.model.Todo[] filterFindByCompanyId_GroupId_UserId_PrevAndNext(
		long todoId, long companyId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.training.todo.NoSuchTodoException {
		return getPersistence()
				   .filterFindByCompanyId_GroupId_UserId_PrevAndNext(todoId,
			companyId, groupId, userId, orderByComparator);
	}

	/**
	* Removes all the todos where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId_GroupId_UserId(long companyId,
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCompanyId_GroupId_UserId(companyId, groupId, userId);
	}

	/**
	* Returns the number of todos where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching todos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId_GroupId_UserId(long companyId,
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCompanyId_GroupId_UserId(companyId, groupId, userId);
	}

	/**
	* Returns the number of todos that the user has permission to view where companyId = &#63; and groupId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching todos that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCompanyId_GroupId_UserId(long companyId,
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterCountByCompanyId_GroupId_UserId(companyId, groupId,
			userId);
	}

	/**
	* Caches the todo in the entity cache if it is enabled.
	*
	* @param todo the todo
	*/
	public static void cacheResult(com.rivetlogic.training.todo.model.Todo todo) {
		getPersistence().cacheResult(todo);
	}

	/**
	* Caches the todos in the entity cache if it is enabled.
	*
	* @param todos the todos
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.training.todo.model.Todo> todos) {
		getPersistence().cacheResult(todos);
	}

	/**
	* Creates a new todo with the primary key. Does not add the todo to the database.
	*
	* @param todoId the primary key for the new todo
	* @return the new todo
	*/
	public static com.rivetlogic.training.todo.model.Todo create(long todoId) {
		return getPersistence().create(todoId);
	}

	/**
	* Removes the todo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param todoId the primary key of the todo
	* @return the todo that was removed
	* @throws com.rivetlogic.training.todo.NoSuchTodoException if a todo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.training.todo.model.Todo remove(long todoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.training.todo.NoSuchTodoException {
		return getPersistence().remove(todoId);
	}

	public static com.rivetlogic.training.todo.model.Todo updateImpl(
		com.rivetlogic.training.todo.model.Todo todo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(todo);
	}

	/**
	* Returns the todo with the primary key or throws a {@link com.rivetlogic.training.todo.NoSuchTodoException} if it could not be found.
	*
	* @param todoId the primary key of the todo
	* @return the todo
	* @throws com.rivetlogic.training.todo.NoSuchTodoException if a todo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.training.todo.model.Todo findByPrimaryKey(
		long todoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.training.todo.NoSuchTodoException {
		return getPersistence().findByPrimaryKey(todoId);
	}

	/**
	* Returns the todo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param todoId the primary key of the todo
	* @return the todo, or <code>null</code> if a todo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.training.todo.model.Todo fetchByPrimaryKey(
		long todoId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(todoId);
	}

	/**
	* Returns all the todos.
	*
	* @return the todos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.training.todo.model.Todo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.rivetlogic.training.todo.model.Todo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rivetlogic.training.todo.model.Todo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the todos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of todos.
	*
	* @return the number of todos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TodoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TodoPersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.training.todo.service.ClpSerializer.getServletContextName(),
					TodoPersistence.class.getName());

			ReferenceRegistry.registerReference(TodoUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TodoPersistence persistence) {
	}

	private static TodoPersistence _persistence;
}
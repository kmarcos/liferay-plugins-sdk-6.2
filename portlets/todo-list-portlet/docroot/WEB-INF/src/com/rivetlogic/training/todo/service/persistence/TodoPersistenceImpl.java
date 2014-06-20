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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rivetlogic.training.todo.NoSuchTodoException;
import com.rivetlogic.training.todo.model.Todo;
import com.rivetlogic.training.todo.model.impl.TodoImpl;
import com.rivetlogic.training.todo.model.impl.TodoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the todo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rivetlogic
 * @see TodoPersistence
 * @see TodoUtil
 * @generated
 */
public class TodoPersistenceImpl extends BasePersistenceImpl<Todo>
	implements TodoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TodoUtil} to access the todo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TodoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
			TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
			TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
			TodoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID_GROUPID_USERID =
		new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
			TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId_GroupId_UserId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID_GROUPID_USERID =
		new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
			TodoModelImpl.FINDER_CACHE_ENABLED, TodoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyId_GroupId_UserId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			TodoModelImpl.COMPANYID_COLUMN_BITMASK |
			TodoModelImpl.GROUPID_COLUMN_BITMASK |
			TodoModelImpl.USERID_COLUMN_BITMASK |
			TodoModelImpl.CREATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID_GROUPID_USERID =
		new FinderPath(TodoModelImpl.ENTITY_CACHE_ENABLED,
			TodoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyId_GroupId_UserId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the todos where companyId = &#63; and groupId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching todos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Todo> findByCompanyId_GroupId_UserId(long companyId,
		long groupId, long userId) throws SystemException {
		return findByCompanyId_GroupId_UserId(companyId, groupId, userId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> findByCompanyId_GroupId_UserId(long companyId,
		long groupId, long userId, int start, int end)
		throws SystemException {
		return findByCompanyId_GroupId_UserId(companyId, groupId, userId,
			start, end, null);
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
	@Override
	public List<Todo> findByCompanyId_GroupId_UserId(long companyId,
		long groupId, long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID_GROUPID_USERID;
			finderArgs = new Object[] { companyId, groupId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID_GROUPID_USERID;
			finderArgs = new Object[] {
					companyId, groupId, userId,
					
					start, end, orderByComparator
				};
		}

		List<Todo> list = (List<Todo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Todo todo : list) {
				if ((companyId != todo.getCompanyId()) ||
						(groupId != todo.getGroupId()) ||
						(userId != todo.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_TODO_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_GROUPID_2);

			query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Todo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Todo>(list);
				}
				else {
					list = (List<Todo>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Todo findByCompanyId_GroupId_UserId_First(long companyId,
		long groupId, long userId, OrderByComparator orderByComparator)
		throws NoSuchTodoException, SystemException {
		Todo todo = fetchByCompanyId_GroupId_UserId_First(companyId, groupId,
				userId, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTodoException(msg.toString());
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
	@Override
	public Todo fetchByCompanyId_GroupId_UserId_First(long companyId,
		long groupId, long userId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Todo> list = findByCompanyId_GroupId_UserId(companyId, groupId,
				userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo findByCompanyId_GroupId_UserId_Last(long companyId,
		long groupId, long userId, OrderByComparator orderByComparator)
		throws NoSuchTodoException, SystemException {
		Todo todo = fetchByCompanyId_GroupId_UserId_Last(companyId, groupId,
				userId, orderByComparator);

		if (todo != null) {
			return todo;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTodoException(msg.toString());
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
	@Override
	public Todo fetchByCompanyId_GroupId_UserId_Last(long companyId,
		long groupId, long userId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyId_GroupId_UserId(companyId, groupId, userId);

		if (count == 0) {
			return null;
		}

		List<Todo> list = findByCompanyId_GroupId_UserId(companyId, groupId,
				userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Todo[] findByCompanyId_GroupId_UserId_PrevAndNext(long todoId,
		long companyId, long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchTodoException, SystemException {
		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = getByCompanyId_GroupId_UserId_PrevAndNext(session, todo,
					companyId, groupId, userId, orderByComparator, true);

			array[1] = todo;

			array[2] = getByCompanyId_GroupId_UserId_PrevAndNext(session, todo,
					companyId, groupId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo getByCompanyId_GroupId_UserId_PrevAndNext(Session session,
		Todo todo, long companyId, long groupId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TODO_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_GROUPID_2);

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TodoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(todo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<Todo> filterFindByCompanyId_GroupId_UserId(long companyId,
		long groupId, long userId) throws SystemException {
		return filterFindByCompanyId_GroupId_UserId(companyId, groupId, userId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Todo> filterFindByCompanyId_GroupId_UserId(long companyId,
		long groupId, long userId, int start, int end)
		throws SystemException {
		return filterFindByCompanyId_GroupId_UserId(companyId, groupId, userId,
			start, end, null);
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
	@Override
	public List<Todo> filterFindByCompanyId_GroupId_UserId(long companyId,
		long groupId, long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCompanyId_GroupId_UserId(companyId, groupId, userId,
				start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_GROUPID_2);

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Todo.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TodoImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TodoImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			qPos.add(userId);

			return (List<Todo>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public Todo[] filterFindByCompanyId_GroupId_UserId_PrevAndNext(
		long todoId, long companyId, long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchTodoException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByCompanyId_GroupId_UserId_PrevAndNext(todoId,
				companyId, groupId, userId, orderByComparator);
		}

		Todo todo = findByPrimaryKey(todoId);

		Session session = null;

		try {
			session = openSession();

			Todo[] array = new TodoImpl[3];

			array[0] = filterGetByCompanyId_GroupId_UserId_PrevAndNext(session,
					todo, companyId, groupId, userId, orderByComparator, true);

			array[1] = todo;

			array[2] = filterGetByCompanyId_GroupId_UserId_PrevAndNext(session,
					todo, companyId, groupId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Todo filterGetByCompanyId_GroupId_UserId_PrevAndNext(
		Session session, Todo todo, long companyId, long groupId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_GROUPID_2);

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_USERID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TodoModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TodoModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Todo.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TodoImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TodoImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(todo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Todo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the todos where companyId = &#63; and groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId_GroupId_UserId(long companyId, long groupId,
		long userId) throws SystemException {
		for (Todo todo : findByCompanyId_GroupId_UserId(companyId, groupId,
				userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(todo);
		}
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
	@Override
	public int countByCompanyId_GroupId_UserId(long companyId, long groupId,
		long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID_GROUPID_USERID;

		Object[] finderArgs = new Object[] { companyId, groupId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TODO_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_GROUPID_2);

			query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
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
	@Override
	public int filterCountByCompanyId_GroupId_UserId(long companyId,
		long groupId, long userId) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByCompanyId_GroupId_UserId(companyId, groupId, userId);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_TODO_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_GROUPID_2);

		query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_USERID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Todo.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN,
				groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			qPos.add(groupId);

			qPos.add(userId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_COMPANYID_GROUPID_USERID_COMPANYID_2 =
		"todo.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYID_GROUPID_USERID_GROUPID_2 =
		"todo.groupId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYID_GROUPID_USERID_USERID_2 =
		"todo.userId = ?";

	public TodoPersistenceImpl() {
		setModelClass(Todo.class);
	}

	/**
	 * Caches the todo in the entity cache if it is enabled.
	 *
	 * @param todo the todo
	 */
	@Override
	public void cacheResult(Todo todo) {
		EntityCacheUtil.putResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
			TodoImpl.class, todo.getPrimaryKey(), todo);

		todo.resetOriginalValues();
	}

	/**
	 * Caches the todos in the entity cache if it is enabled.
	 *
	 * @param todos the todos
	 */
	@Override
	public void cacheResult(List<Todo> todos) {
		for (Todo todo : todos) {
			if (EntityCacheUtil.getResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
						TodoImpl.class, todo.getPrimaryKey()) == null) {
				cacheResult(todo);
			}
			else {
				todo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all todos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TodoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TodoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the todo.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Todo todo) {
		EntityCacheUtil.removeResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
			TodoImpl.class, todo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Todo> todos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Todo todo : todos) {
			EntityCacheUtil.removeResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
				TodoImpl.class, todo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new todo with the primary key. Does not add the todo to the database.
	 *
	 * @param todoId the primary key for the new todo
	 * @return the new todo
	 */
	@Override
	public Todo create(long todoId) {
		Todo todo = new TodoImpl();

		todo.setNew(true);
		todo.setPrimaryKey(todoId);

		return todo;
	}

	/**
	 * Removes the todo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo that was removed
	 * @throws com.rivetlogic.training.todo.NoSuchTodoException if a todo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Todo remove(long todoId) throws NoSuchTodoException, SystemException {
		return remove((Serializable)todoId);
	}

	/**
	 * Removes the todo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the todo
	 * @return the todo that was removed
	 * @throws com.rivetlogic.training.todo.NoSuchTodoException if a todo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Todo remove(Serializable primaryKey)
		throws NoSuchTodoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Todo todo = (Todo)session.get(TodoImpl.class, primaryKey);

			if (todo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTodoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(todo);
		}
		catch (NoSuchTodoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Todo removeImpl(Todo todo) throws SystemException {
		todo = toUnwrappedModel(todo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(todo)) {
				todo = (Todo)session.get(TodoImpl.class, todo.getPrimaryKeyObj());
			}

			if (todo != null) {
				session.delete(todo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (todo != null) {
			clearCache(todo);
		}

		return todo;
	}

	@Override
	public Todo updateImpl(com.rivetlogic.training.todo.model.Todo todo)
		throws SystemException {
		todo = toUnwrappedModel(todo);

		boolean isNew = todo.isNew();

		TodoModelImpl todoModelImpl = (TodoModelImpl)todo;

		Session session = null;

		try {
			session = openSession();

			if (todo.isNew()) {
				session.save(todo);

				todo.setNew(false);
			}
			else {
				session.merge(todo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TodoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((todoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID_GROUPID_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						todoModelImpl.getOriginalCompanyId(),
						todoModelImpl.getOriginalGroupId(),
						todoModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID_GROUPID_USERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID_GROUPID_USERID,
					args);

				args = new Object[] {
						todoModelImpl.getCompanyId(), todoModelImpl.getGroupId(),
						todoModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID_GROUPID_USERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID_GROUPID_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
			TodoImpl.class, todo.getPrimaryKey(), todo);

		return todo;
	}

	protected Todo toUnwrappedModel(Todo todo) {
		if (todo instanceof TodoImpl) {
			return todo;
		}

		TodoImpl todoImpl = new TodoImpl();

		todoImpl.setNew(todo.isNew());
		todoImpl.setPrimaryKey(todo.getPrimaryKey());

		todoImpl.setTodoId(todo.getTodoId());
		todoImpl.setCompanyId(todo.getCompanyId());
		todoImpl.setGroupId(todo.getGroupId());
		todoImpl.setUserId(todo.getUserId());
		todoImpl.setTaskDescription(todo.getTaskDescription());
		todoImpl.setFinished(todo.isFinished());
		todoImpl.setCreatedDate(todo.getCreatedDate());
		todoImpl.setFinishedDate(todo.getFinishedDate());

		return todoImpl;
	}

	/**
	 * Returns the todo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the todo
	 * @return the todo
	 * @throws com.rivetlogic.training.todo.NoSuchTodoException if a todo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Todo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTodoException, SystemException {
		Todo todo = fetchByPrimaryKey(primaryKey);

		if (todo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTodoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return todo;
	}

	/**
	 * Returns the todo with the primary key or throws a {@link com.rivetlogic.training.todo.NoSuchTodoException} if it could not be found.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo
	 * @throws com.rivetlogic.training.todo.NoSuchTodoException if a todo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Todo findByPrimaryKey(long todoId)
		throws NoSuchTodoException, SystemException {
		return findByPrimaryKey((Serializable)todoId);
	}

	/**
	 * Returns the todo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the todo
	 * @return the todo, or <code>null</code> if a todo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Todo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Todo todo = (Todo)EntityCacheUtil.getResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
				TodoImpl.class, primaryKey);

		if (todo == _nullTodo) {
			return null;
		}

		if (todo == null) {
			Session session = null;

			try {
				session = openSession();

				todo = (Todo)session.get(TodoImpl.class, primaryKey);

				if (todo != null) {
					cacheResult(todo);
				}
				else {
					EntityCacheUtil.putResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
						TodoImpl.class, primaryKey, _nullTodo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TodoModelImpl.ENTITY_CACHE_ENABLED,
					TodoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return todo;
	}

	/**
	 * Returns the todo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param todoId the primary key of the todo
	 * @return the todo, or <code>null</code> if a todo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Todo fetchByPrimaryKey(long todoId) throws SystemException {
		return fetchByPrimaryKey((Serializable)todoId);
	}

	/**
	 * Returns all the todos.
	 *
	 * @return the todos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Todo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Todo> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Todo> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Todo> list = (List<Todo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TODO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TODO;

				if (pagination) {
					sql = sql.concat(TodoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Todo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Todo>(list);
				}
				else {
					list = (List<Todo>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the todos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Todo todo : findAll()) {
			remove(todo);
		}
	}

	/**
	 * Returns the number of todos.
	 *
	 * @return the number of todos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TODO);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the todo persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.training.todo.model.Todo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Todo>> listenersList = new ArrayList<ModelListener<Todo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Todo>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TodoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TODO = "SELECT todo FROM Todo todo";
	private static final String _SQL_SELECT_TODO_WHERE = "SELECT todo FROM Todo todo WHERE ";
	private static final String _SQL_COUNT_TODO = "SELECT COUNT(todo) FROM Todo todo";
	private static final String _SQL_COUNT_TODO_WHERE = "SELECT COUNT(todo) FROM Todo todo WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "todo.todoId";
	private static final String _FILTER_SQL_SELECT_TODO_WHERE = "SELECT DISTINCT {todo.*} FROM training_Todo todo WHERE ";
	private static final String _FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {training_Todo.*} FROM (SELECT DISTINCT todo.todoId FROM training_Todo todo WHERE ";
	private static final String _FILTER_SQL_SELECT_TODO_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN training_Todo ON TEMP_TABLE.todoId = training_Todo.todoId";
	private static final String _FILTER_SQL_COUNT_TODO_WHERE = "SELECT COUNT(DISTINCT todo.todoId) AS COUNT_VALUE FROM training_Todo todo WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "todo";
	private static final String _FILTER_ENTITY_TABLE = "training_Todo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "todo.";
	private static final String _ORDER_BY_ENTITY_TABLE = "training_Todo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Todo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Todo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TodoPersistenceImpl.class);
	private static Todo _nullTodo = new TodoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Todo> toCacheModel() {
				return _nullTodoCacheModel;
			}
		};

	private static CacheModel<Todo> _nullTodoCacheModel = new CacheModel<Todo>() {
			@Override
			public Todo toEntityModel() {
				return _nullTodo;
			}
		};
}
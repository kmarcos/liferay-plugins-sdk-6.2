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

package com.rivetlogic.training.todo.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.rivetlogic.training.todo.model.Todo;
import com.rivetlogic.training.todo.service.base.TodoLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the todo local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.rivetlogic.training.todo.service.TodoLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author rivetlogic
 * @see com.rivetlogic.training.todo.service.base.TodoLocalServiceBaseImpl
 * @see com.rivetlogic.training.todo.service.TodoLocalServiceUtil
 */
public class TodoLocalServiceImpl extends TodoLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     * 
     * Never reference this interface directly. Always use {@link
     * com.rivetlogic.training.todo.service.TodoLocalServiceUtil} to access the
     * todo local service.
     */

    public Todo addTask(Todo todo) throws SystemException, PortalException {
        
        long todoId = counterLocalService.increment(Todo.class.getName());
        
        Todo newTodo = todoPersistence.create(todoId);
        newTodo.setCompanyId(todo.getCompanyId());
        newTodo.setGroupId(todo.getGroupId());
        newTodo.setUserId(todo.getUserId());
        newTodo.setTaskDescription(todo.getTaskDescription());
        newTodo.setFinished(false);
        newTodo.setCreatedDate(new Date());
        newTodo.setFinishedDate(null);
        
        todoPersistence.update(newTodo);

        resourceLocalService.addResources(newTodo.getCompanyId(), newTodo.getGroupId(), newTodo.getUserId(),
                Todo.class.getName(), todoId, false, true, true);

        return newTodo;
    }
    
    public Todo updateTask(Todo todo) throws SystemException{
        
        if (todo.getFinished() && todo.getFinishedDate() == null){
            todo.setFinishedDate(new Date());
        }
        
        if (!todo.getFinished()){
            todo.setFinishedDate(null);
        }
               
        return todoPersistence.update(todo);
    }
    
    public List<Todo> getTodoListByCompanyGroupAndUser(long companyId, long groupId, long userId) throws SystemException{
        
        return todoPersistence.findByCompanyId_GroupId_UserId(companyId, groupId, userId);
    }
    
    public int getTodoListCountByCompanyGroupAndUser(long companyId, long groupId, long userId) throws SystemException {
        
        return todoPersistence.countByCompanyId_GroupId_UserId(companyId, groupId, userId);
    }
}
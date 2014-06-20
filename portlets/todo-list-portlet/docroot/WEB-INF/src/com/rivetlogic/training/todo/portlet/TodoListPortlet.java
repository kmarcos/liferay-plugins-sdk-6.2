package com.rivetlogic.training.todo.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rivetlogic.training.todo.model.Todo;
import com.rivetlogic.training.todo.model.impl.TodoImpl;
import com.rivetlogic.training.todo.service.TodoLocalServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

/**
 * Portlet implementation class TodoListPortlet
 */
public class TodoListPortlet extends MVCPortlet {

    public static final String MVC_PATH = "mvcPath";
    public static final String REDIRECT = "redirect";
    public static final String EDIT_TODO_PATH = "/html/todo_list/edit_todo.jsp";
    private static final long NO_ID = 0;

    public void addTodo(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long groupId = themeDisplay.getScopeGroupId();

        if (themeDisplay.getPermissionChecker().hasPermission(groupId, TodoListConstants.RESOURCE_MODEL, groupId,
                TodoListConstants.PERMISION_ADD_TODO)) {

            Todo newTodo = getTodoFromRequest(request);

            ArrayList<String> errors = new ArrayList<String>();

            if (validateTodo(newTodo, errors)) {

                TodoLocalServiceUtil.addTask(newTodo);
                SessionMessages.add(request, TodoListConstants.SUCCESS_TODO_ADDED);

                sendRedirect(request, response);
            } else {
                for (String error : errors) {
                    SessionErrors.add(request, error);
                }

                PortalUtil.copyRequestParameters(request, response);

                response.setRenderParameter(MVC_PATH, EDIT_TODO_PATH);
            }
        } else {
            SessionErrors.add(request, TodoListConstants.ERROR_PERMISSION);
            sendRedirect(request, response);
        }
    }

    public void updateTodo(ActionRequest request, ActionResponse response) throws SystemException, IOException, PortalException {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long groupId = themeDisplay.getScopeGroupId();

        Todo todo = getTodoFromRequest(request);

        if (themeDisplay.getPermissionChecker().hasPermission(groupId, TodoListConstants.RESOURCE_TODO_MODEL,
                todo.getTodoId(), ActionKeys.UPDATE)) {

            ArrayList<String> errors = new ArrayList<String>();

            if (validateTodo(todo, errors)) {
                TodoLocalServiceUtil.updateTask(todo);

                SessionMessages.add(request, TodoListConstants.SUCCESS_TODO_UPDATED);

                sendRedirect(request, response);
            } else {

                for (String error : errors) {
                    SessionErrors.add(request, error);
                }

                PortalUtil.copyRequestParameters(request, response);

                response.setRenderParameter(MVC_PATH, EDIT_TODO_PATH);
            }
        } else {
            SessionErrors.add(request, TodoListConstants.ERROR_PERMISSION);
            sendRedirect(request, response);
        }
    }

    private Todo getTodoFromRequest(PortletRequest request) throws PortalException, SystemException {
        
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        
        long todoId = ParamUtil.getLong(request, TodoListConstants.TODO_ID, NO_ID);
        
        Todo todo = null;
        
        if (todoId != NO_ID){
            todo = TodoLocalServiceUtil.getTodo(todoId);
        }
        else{
            todo = new TodoImpl();
            todo.setCompanyId(themeDisplay.getCompanyId());
            todo.setGroupId(themeDisplay.getScopeGroupId());
            todo.setUserId(themeDisplay.getUserId());
        }        

        todo.setTaskDescription(ParamUtil.getString(request, TodoListConstants.TODO_DESCRIPTION));
        todo.setFinished(ParamUtil.getBoolean(request, TodoListConstants.TODO_FINISHED));
        
        return todo;
    }

    private boolean validateTodo(Todo todo, List<String> errors) {
        
        boolean valid = true;

        if (Validator.isNull(todo.getTaskDescription())) {
            errors.add(TodoListConstants.ERROR_TASK_DECRIPTION_REQUIRED);
            valid = false;
        }

        return valid;
    }
}

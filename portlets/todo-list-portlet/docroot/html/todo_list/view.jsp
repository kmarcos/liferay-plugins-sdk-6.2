<%@include file="/html/todo_list/init.jsp" %>

<%
	boolean hasAddPermission = permissionChecker.hasPermission(
			scopeGroupId, TodoListConstants.RESOURCE_MODEL,
			scopeGroupId, TodoListConstants.PERMISION_ADD_TODO);

	String redirect = PortalUtil.getCurrentURL(renderRequest);	
%>

<liferay-ui:header title="todo.title.todo-list" />

<liferay-ui:success key="<%=TodoListConstants.SUCCESS_TODO_ADDED%>" message="todo.message.todo-added-successfully" />
<liferay-ui:success key="<%=TodoListConstants.SUCCESS_TODO_UPDATED%>" message="todo.message.todo-updated-successfully" />
<liferay-ui:success key="<%=TodoListConstants.ERROR_TASK_DECRIPTION_REQUIRED%>" message="todo.message.task-description-required" />
<liferay-ui:error key="<%=TodoListConstants.ERROR_PERMISSION%>" message="todo.message.error-permission" />

<liferay-ui:search-container emptyResultsMessage="todo.message.todo-list-empty-results">
	<liferay-ui:search-container-results
		results="<%= TodoLocalServiceUtil.getTodoListByCompanyGroupAndUser(company.getCompanyId(), scopeGroupId, user.getUserId()) %>"
		total="<%= TodoLocalServiceUtil.getTodoListCountByCompanyGroupAndUser(company.getCompanyId(), scopeGroupId, user.getUserId()) %>"
	/>

	<liferay-ui:search-container-row
		className="com.rivetlogic.training.todo.model.Todo"
		keyProperty="<%= TodoListConstants.TODO_ID %>"
		modelVar="todo" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text name="">
			<aui:input name="<%= TodoListConstants.TODO_FINISHED + todo.getTodoId() %>" label="" type="checkbox" value="<%= todo.getFinished() %>" disabled="true" />
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text
			name="todo.header.task-description"
			property="<%= TodoListConstants.TODO_DESCRIPTION %>"
		/>

		<liferay-ui:search-container-column-text name="todo.header.dates">
			<c:if test="<%= todo.getCreatedDate() != null %>">
				<%= dateFormatDate.format(todo.getCreatedDate()) %>
			</c:if>
			<c:if test="<%= todo.getFinished() && todo.getFinishedDate() != null %>">
				<liferay-ui:message key="todo.message.dates.separator"/>
				<%= dateFormatDate.format(todo.getFinishedDate()) %>
			</c:if>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="">
			<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, TodoListConstants.RESOURCE_TODO_MODEL, todo.getTodoId(), ActionKeys.UPDATE) %>">
				<portlet:renderURL var="editURL">
					<portlet:param name="<%= TodoListPortlet.MVC_PATH %>" value="<%= TodoListPortlet.EDIT_TODO_PATH %>" />
					<portlet:param name="<%= TodoListConstants.TODO_ID %>" value="<%= String.valueOf(todo.getTodoId()) %>" />
					<portlet:param name="<%= TodoListPortlet.REDIRECT %>" value="<%= redirect %>" />
				</portlet:renderURL>
				
				<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />				
			</c:if>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>

<aui:button-row>
	<c:if test='<%= hasAddPermission %>'>
		<portlet:renderURL var="addTodoURL">
			<portlet:param name="<%= TodoListPortlet.MVC_PATH %>" value="<%= TodoListPortlet.EDIT_TODO_PATH %>" />
			<portlet:param name="<%= TodoListPortlet.REDIRECT %>" value="<%= redirect %>" />
		</portlet:renderURL>

		<aui:button value="todo.button.add-todo" onClick="<%= addTodoURL.toString() %>" />
	</c:if>

</aui:button-row>

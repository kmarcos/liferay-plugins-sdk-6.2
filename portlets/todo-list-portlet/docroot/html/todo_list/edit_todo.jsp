<%@include file="/html/todo_list/init.jsp" %>

<%
	Todo todo = null;

	long todoId = ParamUtil.getLong(request, TodoListConstants.TODO_ID);

	if (todoId > 0) {
		todo = TodoLocalServiceUtil.getTodo(todoId);
	}

	String redirect = ParamUtil.getString(request, TodoListPortlet.REDIRECT);
%>

<portlet:renderURL var="viewTodoListURL" />

<portlet:actionURL name='<%= todo == null ? "addTodo" : "updateTodo" %>' var="editTodoURL" windowState="normal" />

<aui:model-context bean="<%= todo %>" model="<%= Todo.class %>" />

<liferay-ui:header
	backURL="<%= viewTodoListURL %>"
	title='<%= (todo != null) ? "todo.title.edit-todo" : "todo.title.new-todo" %>'
/>

<liferay-ui:success key="<%=TodoListConstants.SUCCESS_TODO_ADDED%>" message="todo.message.todo-added-successfully" />
<liferay-ui:success key="<%=TodoListConstants.SUCCESS_TODO_UPDATED%>" message="todo.message.todo-updated-successfully" />
<liferay-ui:success key="<%=TodoListConstants.ERROR_TASK_DECRIPTION_REQUIRED%>" message="todo.message.task-description-required" />
<liferay-ui:error key="<%=TodoListConstants.ERROR_PERMISSION%>" message="todo.message.error-permission" />

<aui:form action="<%= editTodoURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="<%=TodoListPortlet.REDIRECT %>" value="<%= redirect %>" />

		<aui:input type="hidden" name="<%= TodoListConstants.TODO_ID %>" value='<%= todo == null ? "" : todo.getTodoId() %>'/>

		<liferay-ui:error key="<%= TodoListConstants.ERROR_TASK_DECRIPTION_REQUIRED %>" message="todo.message.task-description-required" />
		<aui:input name="<%= TodoListConstants.TODO_DESCRIPTION %>" />

		<c:if test="<%= todo != null %>" >
			<aui:input name="<%= TodoListConstants.TODO_FINISHED %>" type="checkbox" value="<%= todo.getFinished() %>"/>
		</c:if>
	
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= viewTodoListURL %>" />
	</aui:button-row>
	
</aui:form>
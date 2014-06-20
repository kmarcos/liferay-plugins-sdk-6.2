<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %>

<%@ page import="java.text.Format" %>

<%@ page import="com.rivetlogic.training.todo.portlet.TodoListConstants" %>
<%@ page import="com.rivetlogic.training.todo.portlet.TodoListPortlet" %>
<%@ page import="com.rivetlogic.training.todo.service.TodoLocalServiceUtil" %>
<%@ page import="com.rivetlogic.training.todo.model.Todo" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
Format dateFormatDate = FastDateFormatFactoryUtil.getSimpleDateFormat("dd-MM-yyyy", locale, timeZone);
%>
<%@include file="/html/hobbies/init.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<portlet:renderURL var="editHobbiesURL">
	<portlet:param name="mvcPath" value="/html/hobbies/edit_hobbies.jsp" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<liferay-ui:header title='hobbies' />

<liferay-ui:error key="<%= HobbiesPortlet.HOBBIES_UPDATE_ERROR %>" message="hobbies-not-updated" />
<liferay-ui:success key="<%= HobbiesPortlet.HOBBIES_UPDATE_SUCCESS %>" message="hobbies-updated-successfully" />

<liferay-ui:message key="my-hobbies-message" />

<liferay-ui:custom-attribute
        className="<%= User.class.getName() %>"
        classPK="<%= user.getUserId() %>"
        editable="<%= false %>"
        label="my-hobbies"
        name="<%= HobbiesPortlet.USER_HOBBIES_EXPANDO_FIELD  %>"
/>

<aui:button value="edit-hobbies" onClick="<%= editHobbiesURL.toString() %>" />
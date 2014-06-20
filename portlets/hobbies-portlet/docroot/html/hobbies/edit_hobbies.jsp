<%@include file="/html/hobbies/init.jsp" %>

<portlet:renderURL var="viewUserHobbiesURL" />

<portlet:actionURL name="addUserHobbies" var="addUserHobbiesURL" windowState="normal" />

<liferay-ui:header backURL="<%= viewUserHobbiesURL %>" title='hobbies.title.hobbies' />

<aui:form action="<%= addUserHobbiesURL %>" method="POST" name="fm">
	
	<aui:fieldset>
		<liferay-ui:custom-attribute
	        className="<%= User.class.getName() %>"
	        classPK="<%= user.getUserId() %>"
	        editable="<%= true %>"
	        label="hobbies.label.hobbies-list"
	        name="<%= HobbiesPortlet.USER_HOBBIES_EXPANDO_FIELD  %>"
		/>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= viewUserHobbiesURL %>" />		
	</aui:button-row>
	
</aui:form>

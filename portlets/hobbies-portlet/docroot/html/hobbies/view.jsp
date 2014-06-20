<%@include file="/html/hobbies/init.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<portlet:renderURL var="editHobbiesURL">
	<portlet:param name="<%= HobbiesPortlet.MVC_PATH %>" value="<%=HobbiesPortlet.EDIT_TODO_PATH %>" />
	<portlet:param name="<%= HobbiesPortlet.REDIRECT %>" value="<%= redirect %>" />
</portlet:renderURL>

<portlet:renderURL var="showCarouselURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="<%= HobbiesPortlet.MVC_PATH %>" value="<%=HobbiesPortlet.CAROUSEL_PATH %>" />
	<portlet:param name="<%= HobbiesPortlet.REDIRECT %>" value="<%= redirect %>" />
</portlet:renderURL>

<liferay-ui:header title='hobbies.title.hobbies' />

<liferay-ui:error key="<%= HobbiesPortlet.HOBBIES_UPDATE_ERROR %>" message="hobbies.error.hobbies-not-updated" />
<liferay-ui:success key="<%= HobbiesPortlet.HOBBIES_UPDATE_SUCCESS %>" message="hobbies.message.hobbies-updated-successfully" />

<aui:layout>

	<aui:column columnWidth="50" first="true"> 
		<liferay-ui:message key="hobbies.label.my-hobbies-list" />
	</aui:column>
	
	<aui:column columnWidth="50" last="true" cssClass="hobbies-list"> 
		<liferay-ui:custom-attribute
		        className="<%= User.class.getName() %>"
		        classPK="<%= user.getUserId() %>"
		        editable="<%= false %>"
		        label="hobbies.label.my-hobbies"
		        name="<%= HobbiesPortlet.USER_HOBBIES_EXPANDO_FIELD  %>"
		/>
	</aui:column>
	
</aui:layout>

<aui:button value="hobbies.button.edit-hobbies" onClick="<%= editHobbiesURL.toString() %>" />
<aui:button value="hobbies.button.carousel" id="carouselButton" />


<aui:script use="aui-io-plugin-deprecated">
var carouselButton = A.one('#carouselButton');
	if (carouselButton) {
            carouselButton.on('click',function(event) {
            	var popup =  Liferay.Util.Window.getWindow(
				               {
				                   dialog: {
				                       centered: true,
				                       constrain2view: true,
				                       width: 750,
				                       height: 340
				                   },
				                   title: '<liferay-ui:message key="hobbies.title.carousel" />',
			           			}
			           ).plug(
			               A.Plugin.IO,
			               {
			                   uri:'<%= showCarouselURL.toString() %>'
			               }
			           ).render();
                }
        );
}
</aui:script>
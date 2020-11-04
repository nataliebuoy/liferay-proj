<%@ include file="/init.jsp" %>

<portlet:renderURL var="addUserURL">
    <portlet:param name="mvcPath" value="/addUser.jsp"></portlet:param>
</portlet:renderURL>

<aui:button-row>
    <aui:button onClick="<%= addUserURL.toString() %>" value="Add User"></aui:button>
</aui:button-row>
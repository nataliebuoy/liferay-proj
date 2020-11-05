<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${themeDisplay.isSignedIn()}">
        <h1>User Profile</h1>
		<br>
		<b>Name: </b> <%= user.getFullName() %> 
		<br>
		<b>Email: </b> <%= user.getEmailAddress() %>
		<br>
		<b>Screen Name: </b> <%= user.getScreenName() %>
		
		<portlet:renderURL var="addUserURL">
	    	<portlet:param name="mvcPath" value="/addUser.jsp"></portlet:param>
		</portlet:renderURL>
		
		<aui:button-row>
		    <aui:button onClick="<%= addUserURL.toString() %>" value="Create new account"></aui:button>
		</aui:button-row>
		
    </c:when>
    <c:otherwise>
    
	    Welcome, guest.
	    
    </c:otherwise>
</c:choose>
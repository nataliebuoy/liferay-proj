<%@ include file="/init.jsp" %>

<h1>User Profile</h1>
<br>
<b>Name: </b> <%= user.getFullName() %> 
<br>
<b>Email: </b> <%= user.getEmailAddress() %>
<br>
<b>Screen Name: </b> <%= user.getScreenName() %>
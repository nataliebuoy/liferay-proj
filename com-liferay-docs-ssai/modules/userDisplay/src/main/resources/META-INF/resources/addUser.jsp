<%@ include file="/init.jsp" %>


<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addUser" var="addUserURL"></portlet:actionURL>

<aui:form action="<%= addUserURL %>" name="<portlet:namespace />fm">
        <aui:fieldset>
            <aui:input name="first">
            	<aui:validator name="required" />
            	<aui:validator name="alpha" />
            </aui:input>
            <aui:input name="last">
            	<aui:validator name="required" />
            	<aui:validator name="alpha" />
            </aui:input>
            <aui:input name="email" type="email">
            	<aui:validator name="required" />
            </aui:input>
            <aui:input name="screenName">
            	<aui:validator name="required" />
            </aui:input>
            
           	<liferay-ui:input-date name="DateOfBirth" formName="DateOfBirth"
	            monthParam="birthMonth" monthValue="0" 
	            dayParam="birthDate" dayValue="1" 
	            yearParam="birthYear" yearValue="1900">
	            <h5>Date of Birth</h5>
        	</liferay-ui:input-date> <p>
	        	
            
            <aui:input name="password1" type="password" >
            	<aui:validator name="required" />
            </aui:input>
            <aui:input name="password2" type="password">
            	<aui:validator name="required" />
            	<aui:validator name="equalTo">'#<portlet:namespace />password1'</aui:validator>
            </aui:input>
            
        </aui:fieldset>
        
        <aui:button-row>
            <aui:button type="submit"></aui:button>
            <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
        </aui:button-row>
        
</aui:form>
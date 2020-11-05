package userDisplay.portlet;

import userDisplay.constants.UserDisplayPortletKeys;

import com.liferay.announcements.kernel.model.AnnouncementsDelivery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.EmailAddress;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Website;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author nataliebui
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=UserDisplay",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + UserDisplayPortletKeys.USERDISPLAY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UserDisplayPortlet extends MVCPortlet {
	public void addUser(ActionRequest request, ActionResponse response) throws PortalException {
		try {
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			System.out.println(CompanyLocalServiceUtil.getCompanyById(themeDisplay.getCompanyId()).getName());
	        
			//long creatorUserId = themeDisplay.getUserId(); //33501
		    long companyId = themeDisplay.getCompanyId();
		    boolean autoPassword = false;
		    boolean autoScreenName = false;
		    long facebookId = 0;
		    String openId = "";
		    Locale locale = new Locale(openId);
		    String middleName = "";
		    long prefixId = 0;
		    long suffixId = 0;
		    boolean male = false;
		    String jobTitle = null;
		    long[] groupIds = null;
		    long[] organizationIds = null;
		    long[] roleIds = null;
		    long[] userGroupIds = null;
		    boolean sendEmail = false;
		    ServiceContext serviceContext = new ServiceContext();
		    List<Address> addresses = new ArrayList<Address>();
		    List<EmailAddress> emailAddresses = new ArrayList<EmailAddress>();
		    List<Phone> phones = new ArrayList<Phone>();
		    List<Website> websites = new ArrayList<Website>();
		    List<AnnouncementsDelivery> announcementsDelivers = new ArrayList<AnnouncementsDelivery>();

			String firstName = ParamUtil.getString(request, "first");
	        String lastName = ParamUtil.getString(request, "last");
	        String email = ParamUtil.getString(request, "email");
	        String screenName = ParamUtil.getString(request, "screenName");
	        int birthdayMonth = ParamUtil.getInteger(request, "birthMonth");
	        int birthdayDay = ParamUtil.getInteger(request, "birthDate");
	        int birthdayYear = ParamUtil.getInteger(request, "birthYear");
	        String password1 = ParamUtil.getString(request, "password1");
	        String password2 = ParamUtil.getString(request, "password2");
	        
		    UserServiceUtil.addUser(companyId, autoPassword, password1, password2, autoScreenName, screenName,
		    		email, facebookId, openId, locale, firstName, middleName, lastName, prefixId, suffixId, 
		    		male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, 
		    		userGroupIds, addresses, emailAddresses, phones, websites, announcementsDelivers, sendEmail, serviceContext);
		  
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		}
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		    super.render(renderRequest, renderResponse);
	}
	
}
package com.rivetlogic.training.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

/**
 * Portlet implementation class HobbiesPortlet
 */
public class HobbiesPortlet extends MVCPortlet {

    public static final String USER_HOBBIES_EXPANDO_FIELD = "hobbies";
    public static final String HOBBIES_UPDATE_ERROR = "hobbies-update-error";
    public static final String HOBBIES_UPDATE_SUCCESS = "hobbies-updated";

    private static final Log log = LogFactoryUtil.getLog(HobbiesPortlet.class);

    public void addUserHobbies(ActionRequest request, ActionResponse response) throws IOException, PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();

        try {
            
            ServiceContext serviceContext =  ServiceContextFactory.getInstance(User.class.getName(), request);           
            user.setExpandoBridgeAttributes(serviceContext);
            
            log.debug("hobbies added: " + user.getExpandoBridge().getAttribute(USER_HOBBIES_EXPANDO_FIELD));

            SessionMessages.add(request, HOBBIES_UPDATE_SUCCESS);

        } catch (Exception e) {
            SessionErrors.add(request, HOBBIES_UPDATE_ERROR);
            log.error(e);
        }
    }

}

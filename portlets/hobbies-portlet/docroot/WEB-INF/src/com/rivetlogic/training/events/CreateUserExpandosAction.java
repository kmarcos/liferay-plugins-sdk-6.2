package com.rivetlogic.training.events;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.DuplicateColumnNameException;
import com.liferay.portlet.expando.NoSuchTableException;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.rivetlogic.training.portlet.HobbiesPortlet;

public class CreateUserExpandosAction extends SimpleAction {

    private static final Log log = LogFactoryUtil.getLog(CreateUserExpandosAction.class);

    /*
     * (non-Java-doc)
     * 
     * @see com.liferay.portal.kernel.events.SimpleAction#SimpleAction()
     */
    public CreateUserExpandosAction() {
        super();
    }

    /*
     * (non-Java-doc)
     * 
     * @see com.liferay.portal.kernel.events.SimpleAction#run(String[] arg0)
     */
    public void run(String[] arg0) throws ActionException {
        try {
            createUserExpandos();
        } catch (Exception e) {
            log.error(e);
        }
    }

    private void createUserExpandos() throws PortalException, SystemException {

        ExpandoTable expandoTable = getExpandoTable();
        ExpandoColumn hobbiesColumn = getExpandoColumn(expandoTable, HobbiesPortlet.USER_HOBBIES_EXPANDO_FIELD);

        long companyId = CompanyThreadLocal.getCompanyId();
        Role user = RoleLocalServiceUtil.getRole(companyId, RoleConstants.USER);

        // Set permissions to allow regular users update hobbies
        ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId, ExpandoColumn.class.getName(),
                ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(hobbiesColumn.getColumnId()), user.getRoleId(),
                new String[] { ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.DELETE });

        log.debug("Expando table for User: " + expandoTable.toString());
        log.debug("Expando column for Hobbies: " + hobbiesColumn.toString());

    }

    private ExpandoTable getExpandoTable() throws PortalException, SystemException {

        ExpandoTable table = null;
        try {
            table = ExpandoTableLocalServiceUtil
                    .getDefaultTable(PortalUtil.getDefaultCompanyId(), User.class.getName());
        } catch (NoSuchTableException nste) {
            table = ExpandoTableLocalServiceUtil
                    .addDefaultTable(PortalUtil.getDefaultCompanyId(), User.class.getName());
        }
        return table;
    }

    private ExpandoColumn getExpandoColumn(ExpandoTable table, String columnName) throws PortalException,
            SystemException {

        ExpandoColumn column = null;
        long tableId = table.getTableId();
        try {
            column = ExpandoColumnLocalServiceUtil.addColumn(tableId, columnName, ExpandoColumnConstants.STRING);

            // Making column as searchable
            UnicodeProperties properties = new UnicodeProperties();
            properties.setProperty(ExpandoColumnConstants.INDEX_TYPE, Boolean.TRUE.toString());
            column.setTypeSettingsProperties(properties);
            ExpandoColumnLocalServiceUtil.updateExpandoColumn(column);

        } catch (DuplicateColumnNameException dcne) {
            column = ExpandoColumnLocalServiceUtil.getColumn(tableId, columnName);
        }
        return column;
    }
}
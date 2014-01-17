/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.lms.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the act man audit local service. This utility wraps {@link com.liferay.lms.service.impl.ActManAuditLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author TLS
 * @see ActManAuditLocalService
 * @see com.liferay.lms.service.base.ActManAuditLocalServiceBaseImpl
 * @see com.liferay.lms.service.impl.ActManAuditLocalServiceImpl
 * @generated
 */
public class ActManAuditLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.lms.service.impl.ActManAuditLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the act man audit to the database. Also notifies the appropriate model listeners.
	*
	* @param actManAudit the act man audit
	* @return the act man audit that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ActManAudit addActManAudit(
		com.liferay.lms.model.ActManAudit actManAudit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addActManAudit(actManAudit);
	}

	/**
	* Creates a new act man audit with the primary key. Does not add the act man audit to the database.
	*
	* @param actManAuditId the primary key for the new act man audit
	* @return the new act man audit
	*/
	public static com.liferay.lms.model.ActManAudit createActManAudit(
		long actManAuditId) {
		return getService().createActManAudit(actManAuditId);
	}

	/**
	* Deletes the act man audit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param actManAuditId the primary key of the act man audit
	* @return the act man audit that was removed
	* @throws PortalException if a act man audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ActManAudit deleteActManAudit(
		long actManAuditId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteActManAudit(actManAuditId);
	}

	/**
	* Deletes the act man audit from the database. Also notifies the appropriate model listeners.
	*
	* @param actManAudit the act man audit
	* @return the act man audit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ActManAudit deleteActManAudit(
		com.liferay.lms.model.ActManAudit actManAudit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteActManAudit(actManAudit);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.liferay.lms.model.ActManAudit fetchActManAudit(
		long actManAuditId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchActManAudit(actManAuditId);
	}

	/**
	* Returns the act man audit with the primary key.
	*
	* @param actManAuditId the primary key of the act man audit
	* @return the act man audit
	* @throws PortalException if a act man audit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ActManAudit getActManAudit(
		long actManAuditId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getActManAudit(actManAuditId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the act man audit with the UUID in the group.
	*
	* @param uuid the UUID of act man audit
	* @param groupId the group id of the act man audit
	* @return the act man audit
	* @throws PortalException if a act man audit with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ActManAudit getActManAuditByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getActManAuditByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the act man audits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of act man audits
	* @param end the upper bound of the range of act man audits (not inclusive)
	* @return the range of act man audits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.lms.model.ActManAudit> getActManAudits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getActManAudits(start, end);
	}

	/**
	* Returns the number of act man audits.
	*
	* @return the number of act man audits
	* @throws SystemException if a system exception occurred
	*/
	public static int getActManAuditsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getActManAuditsCount();
	}

	/**
	* Updates the act man audit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param actManAudit the act man audit
	* @return the act man audit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ActManAudit updateActManAudit(
		com.liferay.lms.model.ActManAudit actManAudit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateActManAudit(actManAudit);
	}

	/**
	* Updates the act man audit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param actManAudit the act man audit
	* @param merge whether to merge the act man audit with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the act man audit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.lms.model.ActManAudit updateActManAudit(
		com.liferay.lms.model.ActManAudit actManAudit, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateActManAudit(actManAudit, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static ActManAuditLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ActManAuditLocalService.class.getName());

			if (invokableLocalService instanceof ActManAuditLocalService) {
				_service = (ActManAuditLocalService)invokableLocalService;
			}
			else {
				_service = new ActManAuditLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ActManAuditLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ActManAuditLocalService service) {
	}

	private static ActManAuditLocalService _service;
}
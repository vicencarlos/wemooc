/**
 * 2012 TELEFONICA LEARNING SERVICES. All rights reserved.
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

package com.liferay.lms.service.impl;

import com.liferay.lms.model.LearningActivity;
import com.liferay.lms.model.LearningActivityTry;
import com.liferay.lms.service.base.LearningActivityTryServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the learning activity try remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.lms.service.LearningActivityTryService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.liferay.lms.service.LearningActivityTryServiceUtil} to access the learning activity try remote service.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author cvicente
 * @see com.liferay.lms.service.base.LearningActivityTryServiceBaseImpl
 * @see com.liferay.lms.service.LearningActivityTryServiceUtil
 */
public class LearningActivityTryServiceImpl
	extends LearningActivityTryServiceBaseImpl 
	{
	public LearningActivityTry createLearningActivityTry(long actId,long userId) throws SystemException
	{
		
		LearningActivityTry lat=learningActivityTryPersistence.create(counterLocalService.increment(
				LearningActivityTry.class.getName()));
		lat.setActId(actId);
		lat.setUserId(userId);
		java.util.Date today=new java.util.Date(System.currentTimeMillis());
		lat.setStartDate(today);
		learningActivityTryPersistence.update(lat, true);
		return lat;
	}
}
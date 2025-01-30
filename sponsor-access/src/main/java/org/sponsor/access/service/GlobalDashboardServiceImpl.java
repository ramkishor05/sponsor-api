package org.sponsor.access.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sponsor.access.constants.Authority;
import org.sponsor.access.constants.RecordStatus;
import org.sponsor.access.model.UIGlobalDashboard;
import org.sponsor.access.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlobalDashboardServiceImpl implements GlobalDashboardService {

	private static final Logger LOGGER= LoggerFactory.getLogger(GlobalDashboardServiceImpl.class);

	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Override
	public UIGlobalDashboard getDashboard() {
		LOGGER.warn("Start geting the data for dashboard");
		UIGlobalDashboard clientDashboard=new UIGlobalDashboard();
		
		clientDashboard.setTotalUsers(userAccountRepository.countByUserRoleRoleNameInAndRecordStateIn(Authority.USER.getRoleNames() , RecordStatus.ACTIVETED.getStatusIds()));

		LOGGER.warn("End geting the data for dashboard");
		return clientDashboard;
	}
}

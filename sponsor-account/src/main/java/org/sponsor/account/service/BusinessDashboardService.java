package org.sponsor.account.service;

import java.util.List;
import java.util.Map;

import org.sponsor.account.model.UIBusinessDashboard;

public interface BusinessDashboardService {

	UIBusinessDashboard getDashboard(Map<String, List<String>> headers);

}

package in.ashokit.service;

import in.ashokit.dto.DashboardResponse;
import in.ashokit.entity.Counsellor;

public interface CounsellorService {

	public Counsellor findByEmail(String email);

	public boolean register(Counsellor counsellor);

	public Counsellor login(String email, String pwd);

	public DashboardResponse getDashboardInfo(Integer counsellorId);

}
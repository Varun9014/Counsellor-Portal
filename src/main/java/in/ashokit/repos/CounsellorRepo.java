package in.ashokit.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Counsellor;

public interface CounsellorRepo extends JpaRepository<Counsellor, Integer> {

	// select * from counsellor_tbl where email=:email
	public Counsellor findByEmail(String gmail);

	// select Counsellor_tbl where email=:email and pwd=:pwd
	public Counsellor findByEmailAndPwd(String email, String pwd);

}

package connection;

import java.util.List;

import entity.Sponsor;

interface SponsorRepository {
	List<Sponsor> findAll();

	void saveSponsor(Sponsor sponsor);

	void updateSponsor(String sponsorId, double sponsorMoney, String sponsorDate);

	void deleteSponsor(Sponsor sponsor);
}

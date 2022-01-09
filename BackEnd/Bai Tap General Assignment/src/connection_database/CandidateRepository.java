package connection_database;

import java.sql.SQLException;
import java.util.List;

import model.Candidate;
import model.CandidateType;
import model.Experience;
import model.Fresher;
import model.Intern;

interface CandidateRepository {
	List<CandidateType> findAllCandidateType();

	List<Candidate> findAll();

	void save(Candidate candidate);

	void saveExperience(Experience experience);

	void saveFresher(Fresher fresher);

	void saveIntern(Intern intern);

	Candidate findById(int id);

	void remove(int id) throws SQLException;

	void update(int id, Candidate candidate);

	Candidate findByName(String name);

}

package connection_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import manager.Main;
import model.Candidate;
import model.CandidateType;
import model.Certificated;
import model.Experience;
import model.Fresher;
import model.Intern;

public class CandidateRepositoryImpl implements CandidateRepository {
	private static Logger logger = Logger.getLogger(CandidateRepositoryImpl.class);

	public static int getCadidateCount() {
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement("SELECT MAX(CandidateID) AS id FROM dbo.Candidate");
			resultSet = statement.executeQuery();
			int id = 1;
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void saveCertificated(Set<Certificated> certificateds) {
		Connection connection = DBConnection.getConnect();
		PreparedStatement statementInsertCertificated = null;
		PreparedStatement statementGetID = null;
		ResultSet resultSet = null;
		try {
			statementGetID = connection.prepareStatement("SELECT MAX(CandidateID) AS id FROM dbo.Candidate");
			resultSet = statementGetID.executeQuery();
			int id = 1;
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			statementInsertCertificated = connection.prepareStatement("INSERT INTO dbo.Certificated"
					+ "(CertificatedName,CertificatedRank,CertificatedDate,CandidateID)VALUES(?,?,?,?)");
			for (Certificated certificated : certificateds) {
				statementInsertCertificated.setString(1, certificated.getCertificateName());
				statementInsertCertificated.setInt(2, certificated.getCertificateRank());
				statementInsertCertificated.setString(3, certificated.getCertificatedDate());
				statementInsertCertificated.setInt(4, id);
				statementInsertCertificated.executeUpdate();
				System.out.println("thêm 1 bằng cấp thành công");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				statementInsertCertificated.close();
				statementGetID.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
			DBConnection.close();
		}

	}

	@Override
	public List<CandidateType> findAllCandidateType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> findAll() {
		List<Candidate> candidates = new ArrayList<>();
		Connection connection = DBConnection.getConnect();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		PreparedStatement statementCertificate = null;
		ResultSet resultSetCertificate = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(
						"SELECT * FROM candidate JOIN candidateType ON CandidateType.CandidateTypeID = Candidate.CandidateTypeID");
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					int CandidateID = resultSet.getInt(1);
					String fullName = resultSet.getString("fullName");
					String birthDate = resultSet.getString("birthDate");
					String phone = resultSet.getString("phone");
					String email = resultSet.getString("email");
					int candidateTypeID = resultSet.getInt(6);
					int candidateCount = resultSet.getInt(1);
					int expInYear = resultSet.getInt("expInYear");
					String proSkill = resultSet.getString("ProSkill");
					String graduationDate = resultSet.getString("graduationDate");
					int graduationRank = resultSet.getInt("graduationRank");
					String education = resultSet.getString("education");
					String majors = resultSet.getString("majors");
					String semester = resultSet.getString("semester");
					String university = resultSet.getString("UniversityName");
					
				
						statementCertificate = connection.prepareStatement(
								"SELECT * FROM dbo.Certificated\r\n"
								+ "WHERE CandidateID = ?");
						statementCertificate.setInt(1, resultSet.getInt(1));
						resultSetCertificate = statementCertificate.executeQuery();
						Set<Certificated> certificateds = new HashSet<Certificated>();
						while (resultSetCertificate.next()) {
							int certificatedID = resultSetCertificate.getInt(1);
							String certificatedName = resultSetCertificate.getString("certificatedName");
							int certificatedRank = resultSetCertificate.getInt("certificatedRank");
							String certificatedDate = resultSetCertificate.getString("certificatedDate");
							certificateds.add(new Certificated(certificatedID, certificatedName, certificatedRank, certificatedDate));
						}
						
						
					
					
					if (candidateTypeID == 0) {
						candidates.add(new Experience(CandidateID, fullName, birthDate, phone, email, candidateTypeID,
								candidateCount, certificateds, expInYear, proSkill));
					} else if (candidateTypeID == 1) {
						candidates.add(new Fresher(CandidateID, fullName, birthDate, phone, email, candidateTypeID,
								candidateCount, certificateds, graduationRank, graduationDate, education));
					} else {
						candidates.add(new Intern(CandidateID, fullName, birthDate, phone, email, candidateTypeID,
								candidateCount, certificateds, majors, semester, university));
					}
				}
			logger.info("Nội dung câu lệnh truy vấn: \n"
					+ "SELECT * FROM candidate JOIN candidateType ON CandidateType.CandidateTypeID = Candidate.CandidateTypeID\n"
					+ "SELECT * FROM dbo.Certificated WHERE CandidateID = ?");
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} finally {
				try {
					resultSet.close();
					statement.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
				DBConnection.close();
			}
		}
		
	
		
	
		
		
		return candidates;
	}

	@Override
	public void save(Candidate candidate) {

	}

	@Override
	public Candidate findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(int id, Candidate candidate) {
		// TODO Auto-generated method stub

	}

	@Override
	public Candidate findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveExperience(Experience experience) {
		Connection connection = DBConnection.getConnect();

		PreparedStatement statement = null;

		if (connection != null) {
			try {

				statement = connection.prepareStatement(
						"INSERT INTO Candidate(FullName,BirthDate,Phone,Email,CandidateTypeID,ExpInYear,ProSkill)VALUES(?,?,?,?,?,?,?)");
				statement.setString(1, experience.getFullName());
				statement.setString(2, experience.getBirthDay());
				statement.setString(3, experience.getPhone());
				statement.setString(4, experience.getEmail());
				statement.setInt(5, experience.getCandidateType());
				statement.setInt(6, experience.getExpInYear());
				statement.setString(7, experience.getProSkillString());
				statement.executeUpdate();
				saveCertificated(experience.getSetCertificateds());
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
				DBConnection.close();
			}
		}

	}

	@Override
	public void saveFresher(Fresher fresher) {
		Connection connection = DBConnection.getConnect();

		PreparedStatement statement = null;

		if (connection != null) {
			try {

				statement = connection.prepareStatement(
						"INSERT INTO Candidate(FullName,BirthDate,Phone,Email,CandidateTypeID,GraduationDate,GraduationRank,Education)VALUES(?,?,?,?,?,?,?,?)");
				statement.setString(1, fresher.getFullName());
				statement.setString(2, fresher.getBirthDay());
				statement.setString(3, fresher.getPhone());
				statement.setString(4, fresher.getEmail());
				statement.setInt(5, fresher.getCandidateType());
				statement.setString(6, fresher.getGraduationDate());
				statement.setInt(7, fresher.getGraduationRank());
				statement.setString(8, fresher.getEducation());
				statement.executeUpdate();
				saveCertificated(fresher.getSetCertificateds());
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
				DBConnection.close();
			}
		}

	}

	@Override
	public void saveIntern(Intern intern) {
		Connection connection = DBConnection.getConnect();

		PreparedStatement statement = null;

		if (connection != null) {
			try {

				statement = connection.prepareStatement(
						"INSERT INTO Candidate(FullName,BirthDate,Phone,Email,CandidateTypeID,Majors,Semester,UniversityName)VALUES(?,?,?,?,?,?,?,?)");
				statement.setString(1, intern.getFullName());
				statement.setString(2, intern.getBirthDay());
				statement.setString(3, intern.getPhone());
				statement.setString(4, intern.getEmail());
				statement.setInt(5, intern.getCandidateType());
				statement.setString(6, intern.getMajors());
				statement.setString(7, intern.getSemester());
				statement.setString(8, intern.getUniversityName());
				statement.executeUpdate();

				saveCertificated(intern.getSetCertificateds());
				System.out.println("thêm bằng cấp thành công");
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
				DBConnection.close();
			}
		}

	}

}

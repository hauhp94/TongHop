package connection_database;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Candidate;
import model.Certificated;
import model.Experience;
import model.Fresher;
import model.Intern;

public class Main {

	public static void main(String[] args) {
//		System.out.println("băt đầu kết nối");
////		DBConnection.getConnect();
//		
//		List<Candidate> candidates = new ArrayList<Candidate>();
//		CandidateRepositoryImpl candidateRepositoryImpl = new CandidateRepositoryImpl();
//		candidates = candidateRepositoryImpl.findAll();
//		for (Candidate candidate : candidates) {
//			candidate.showMe();
//		}
//		Experience experience = new Experience(0, "Nguyễn Vinh", "2020-12-12", "0905123123", "jjj@gmail.com", 0, 2, null, 3, "PHP");
//		Fresher fresher = new Fresher(0, "Trần Vui", "1992-12-12", "0987123321", "ttt@gmail.com", 1, 0, null, 12, "2020-12-12", "DH");
//		Intern intern = new Intern(0, "Lê In", "1997-12-12", "0922123123", "maiin@gmail.com", 2, 0, null, "CNTT", "KHONG", "DHDN");
		Certificated certificated = new Certificated(0, "codegym", 1, "2020-12-12");
		Set<Certificated> certificateds = new HashSet<Certificated>();
		certificateds.add(certificated);
		CandidateRepositoryImpl candidateRepositoryImpl = new CandidateRepositoryImpl();
		candidateRepositoryImpl.saveCertificated(null);
	
	}

}

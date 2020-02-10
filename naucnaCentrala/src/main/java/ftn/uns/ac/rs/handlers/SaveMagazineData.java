package ftn.uns.ac.rs.handlers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.ac.rs.dto.FormSubmissionRequest;
import ftn.uns.ac.rs.model.Clanarina;
import ftn.uns.ac.rs.model.MagazineData;
import ftn.uns.ac.rs.model.UserData;
import ftn.uns.ac.rs.repository.ClanarinaRepository;
import ftn.uns.ac.rs.repository.MagazineDataRepository;
import ftn.uns.ac.rs.repository.UserDataRepository;

@Service
public class SaveMagazineData implements JavaDelegate{
	
	@Autowired
	MagazineDataRepository magazineDataRepository;
	
	@Autowired
	UserDataRepository userDataRepository;
	
	@Autowired
	ClanarinaRepository clanarinaRepository;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		List<FormSubmissionRequest> userData = (List<FormSubmissionRequest>) execution.getVariable("magazineData");
		String procesID = (String) execution.getVariable("procesID");
		//sacuvati podatke magazine i setovati glavnog urednika magazina
		System.out.println("USAO U SaveMagazineData");
		MagazineData magazine = new MagazineData();
		magazine.setAktivnost(true);
		magazine.setGlavniUrednik("urednik");
		magazine.setProcesID(procesID);
		magazine = createMagazineData(userData,magazine);
		
		magazineDataRepository.save(magazine);
		
		if(magazine.getOpenAccess()) {
			Clanarina clanarina = new Clanarina();
			clanarina.setUrednik(true);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 1);
			Date result = cal.getTime();
			clanarina.setDatumDo(result);
			clanarina.setMagazine(magazine);
			clanarina.setNaziv("Urednik uplacuje za open access");
			UserData userdata = userDataRepository.findByUsername("urednik");
			clanarina.setKorisnik(userdata);
			clanarinaRepository.save(clanarina);
		}
	}
	
	private MagazineData createMagazineData(List<FormSubmissionRequest> dto, MagazineData magazine) {
		for (int i = 0; i < dto.size(); i++) {
			if(dto.get(i).getFieldId().equals("naucneOblasti")) {
				magazine.setNaucneOblasti(dto.get(i).getFieldValue());
			}
			if(dto.get(i).getFieldId().equals("naziv")) {
				magazine.setNaziv(dto.get(i).getFieldValue());
			}
			if(dto.get(i).getFieldId().equals("isdn")) {
				magazine.setIsdn(Long.valueOf( dto.get(i).getFieldValue()));
			}
			if(dto.get(i).getFieldId().equals("nacinPlacanja")) {
				if(dto.get(i).getFieldValue().equals("true")) {
					magazine.setOpenAccess(true);
					
				}else
					magazine.setOpenAccess(false);
			}
		}
		
		
		return magazine;
	}
}
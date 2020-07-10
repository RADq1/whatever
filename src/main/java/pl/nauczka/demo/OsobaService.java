package pl.nauczka.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.thymeleaf.templateparser.reader.ParserLevelCommentTextReader;

import java.util.List;
import java.util.Optional;

@Service
public class OsobaService {


    private OsobaRepo osobaRepo;
    @Autowired
    public OsobaService(OsobaRepo osobaRepo) {
        this.osobaRepo = osobaRepo;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void Start(){

        osobaRepo.save(new Osoba("Radosław", "Gackowski", Plec.GENDER, 37.9));
        osobaRepo.save(new Osoba("Radosław", "Czarnecki", Plec.MĘŻCZYZNA, 470.9));
        osobaRepo.save(new Osoba("Dawid", "Kleina", Plec.KOBIETA, 231.0));
        osobaRepo.save(new Osoba("Robert", "Głośnicki", Plec.MĘŻCZYZNA, 1231.0));
        osobaRepo.save(new Osoba("Miłosz", "Grabowski", Plec.MĘŻCZYZNA, 200.0));
        osobaRepo.save(new Osoba("Wiktoria", "Pawłowska", Plec.KOBIETA, 300.0));
        osobaRepo.save(new Osoba("Bartosz", "Leśniak", Plec.MĘŻCZYZNA, 213.0));
        osobaRepo.save(new Osoba("Ania", "Brzuskniewicz", Plec.KOBIETA, 23112.0));
    }

    public List<Osoba> getAll(){
        return osobaRepo.findAll();
    }

    public Osoba getById(Long id){

        Optional<Osoba> result = osobaRepo.findAll().stream().filter(x -> id == x.getId()).findFirst();

        if(result.isPresent()){
            return result.get();
        }
        else{
            return null;
        }


    }
}

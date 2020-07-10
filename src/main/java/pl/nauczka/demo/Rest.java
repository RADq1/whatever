package pl.nauczka.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Rest {

    @Autowired
    private OsobaService osobaService;

    @GetMapping("/abc")
    public List<Osoba> wAbc(){

        return osobaService.getAll();
    }

    @GetMapping("/getId/{id}")
    public Osoba getId(@PathVariable Long id){

        return osobaService.getById(id);
    }

    @GetMapping("/getGender/{gender}")
    public List<Osoba> gender(@PathVariable String gender){
        return osobaService.getAll().stream().filter(x -> x.getPlec().name().equals(gender)).collect(Collectors.toList());
    }

    @GetMapping("/endByA")
    public List<Osoba> endByA(){
        return osobaService.getAll().stream().filter(x -> x.getImie().endsWith("a")).collect(Collectors.toList());
    }

    @GetMapping("/nick")
    public List<String> nick(){
        return osobaService.getAll().stream().map(x -> x.getImie()).collect(Collectors.toList());
    }

   @GetMapping("/cashByGender/{gender}")
    public Double cashByGender(@PathVariable String gender) {
        return osobaService.getAll().stream().filter(x -> x.getPlec().name().equals(gender)).map(x -> x.getCash()).reduce(0.0, (x,y) -> x+y);
   }

//imie i nazwisko w formie Stringa dla kazdej osoby

    @GetMapping("/nameAndsurName")
    public List<String> nameAndsurName(){
        return osobaService.getAll().stream().map(x -> x.getImie()+ " " + x.getNazwisko()).collect(Collectors.toList());
    }
}

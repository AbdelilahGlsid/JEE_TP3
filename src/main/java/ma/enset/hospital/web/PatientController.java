package ma.enset.hospital.web;

import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    /*@GetMapping("/index")
    public String index(Model model){
        List<Patient> patientList=patientRepository.findAll();
        model.addAttribute("listPatients",patientList);
        return "patients";
    }*/

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size",defaultValue = "5") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String kw
    ) {

        Page<Patient> pagePatients = patientRepository.findByNomContains( kw , PageRequest.of(page,size));

        model.addAttribute("listPatients", pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",kw);
        model.addAttribute("repository", patientRepository);
        model.addAttribute("page", page);
        return "patients";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "keyword", defaultValue = "") String keyword


    ){
        patientRepository.deleteById(id);
        return "redirect:/index?keyword="+keyword+"&page="+page;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

}

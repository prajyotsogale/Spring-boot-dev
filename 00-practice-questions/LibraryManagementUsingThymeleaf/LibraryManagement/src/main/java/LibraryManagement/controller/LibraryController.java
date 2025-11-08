package LibraryManagement.controller;

import LibraryManagement.entity.Library;
import LibraryManagement.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LibraryController {

    private LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @GetMapping("/")
    public String sayHello(Model model){
        List<Library> list = libraryService.findAll();
        model.addAttribute("members",list);
        return "showList";
    }

    @GetMapping("/addMember")
    public String addMember(Model model){
        Library library = new Library();
        model.addAttribute("member",library);
        return "addNewMember";
    }

    @GetMapping("/updateMember")
    public String updateMember(@RequestParam("memberId") int id, Model model){
        Library library = libraryService.findById(id);
        model.addAttribute("member",library);
        return "addNewMember";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("member") Library member){
        libraryService.save(member);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("memberId") int id){
        libraryService.delete(id);
        return "redirect:/";
    }

}

package cz.insuranceApp.controllers;

import cz.insuranceApp.models.dto.ClientDTO;
import cz.insuranceApp.models.dto.mappers.ClientMapper;
import cz.insuranceApp.models.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientsControler {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientMapper clientMapper;

    @GetMapping
    public String renderIndex(Model model){
        List<ClientDTO> clients = clientService.getAll();
        model.addAttribute("clients", clients);
        return "pages/clients/index";
    }

    @GetMapping("/create")
    public String renderCreateForm(@ModelAttribute ClientDTO client){
        return "pages/clients/create";
    }
    @PostMapping("/create")
    public String createClient(@Valid @ModelAttribute ClientDTO client,
                               BindingResult result,
                               RedirectAttributes redirectAttributes){
        System.out.println(client.getBirthDate());
        System.out.println(client.getFirstName());
        if(result.hasErrors()){
            return renderCreateForm(client);
        }
        clientService.create(client);
        redirectAttributes.addFlashAttribute("success", "Klient vytvořen");
        return "redirect:/clients";
    }

    @GetMapping("edit/{clientId}")
    public String renderEditForm(@PathVariable long clientId,
                                 ClientDTO client){
        ClientDTO fetchedClient =clientService.getById(clientId);
        clientMapper.updateClientDTO(fetchedClient, client);
        return "pages/clients/edit";
    }
    @PostMapping("/edit/{clientId}")
    public String editeClient(@PathVariable long clientId,
                              @Valid ClientDTO client,
                              BindingResult result,
                              RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return renderEditForm(clientId, client);
        }
        client.setClientId(clientId);
        clientService.edit(client);
        redirectAttributes.addFlashAttribute("success", "Karta klienta upravena");
        return "redirect:/clients";
    }

}

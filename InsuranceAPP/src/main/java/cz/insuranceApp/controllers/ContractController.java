package cz.insuranceApp.controllers;

import cz.insuranceApp.data.entities.ClientEntity;
import cz.insuranceApp.models.dto.ClientDTO;
import cz.insuranceApp.models.dto.ContractDTO;
import cz.insuranceApp.models.dto.mappers.ClientMapper;
import cz.insuranceApp.models.dto.mappers.ContractMapper;
import cz.insuranceApp.models.services.ClientService;
import cz.insuranceApp.models.services.ContractService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    ClientService clientService;
    @Autowired
    ContractService contractService;
    @Autowired
    ContractMapper contractMapper;
    @Autowired
    ClientMapper clientMapper;


    @GetMapping("/create/{clientId}")
    public String renderCreateForm(@PathVariable long clientId,
                                   @ModelAttribute ContractDTO contractDTO,
                                   Model model){
        ClientDTO client = clientService.getById(clientId);
        model.addAttribute("client", client);
        return "pages/contracts/create";
    }
    @PostMapping("/create/{clientId}")
    public String createContract(@PathVariable long clientId,
                                 @Valid @ModelAttribute ContractDTO contractDTO,
                                 Model model,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            ClientDTO clientDTO = clientService.getById(clientId);
            model.addAttribute("client", clientDTO);
            return renderCreateForm(clientId,contractDTO,model);
        }
        ClientEntity clientEntity = clientMapper.toEntity((clientService.getById(clientId)));
        contractService.create(clientEntity,contractDTO);
        redirectAttributes.addAttribute("clientId", clientId);
        redirectAttributes.addFlashAttribute("success", "Smlouva úspěšně přidána.");
        return "redirect:/clients/detail/{clientId}";
    }
    @GetMapping
    public String renderIndex(Model model){
        List<ContractDTO> contracts = contractService.getAll();
        model.addAttribute("contracts", contracts);
        return "pages/contracts/index";
    }
    @GetMapping("/edit/{clientId}/{contractId}")
    public String renderEditForm(@PathVariable long clientId,
                                 @PathVariable long contractId,
                                 ContractDTO contractDTO,
                                 Model model){
        ClientDTO client = clientService.getById(clientId);
        model.addAttribute("client", client);
        ContractDTO fetchedContract = contractService.getById(contractId);
        System.out.println(fetchedContract.getArticle());
        contractMapper.updateContractDTO(fetchedContract, contractDTO);
        System.out.println(contractDTO.getAmount());
        return "/pages/contracts/edit";
    }
    @PostMapping("/edit/{clientId}/{contractId}")
    public String editContract(@PathVariable long clientId,
                               @PathVariable long contractId,
                               @Valid ContractDTO contractDTO,
                               Model model,
                               BindingResult result,
                               RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            ClientDTO clientDTO = clientService.getById(clientId);
            model.addAttribute("client", clientDTO);
            return renderEditForm(clientId, contractId, contractDTO, model);
        }
        contractDTO.setContractId(contractId);
        contractService.edite(contractDTO);
        redirectAttributes.addFlashAttribute("success", "Smlouva upravena");
        redirectAttributes.addAttribute(clientId);
        return "redirect:/clients/detail/{clientId}";
    }

    @GetMapping("/delete/{contractId}")
    public String deleteContract(@PathVariable long contractId,
                                 HttpServletRequest request,
                                 @RequestHeader("Referer") String referer,
                                 RedirectAttributes redirectAttributes){

        contractService.remove(contractId);
        redirectAttributes.addFlashAttribute("success", "Smlouva odebrána");
        return "redirect:" + referer;
    }
}


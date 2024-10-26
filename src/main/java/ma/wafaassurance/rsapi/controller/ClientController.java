package ma.wafaassurance.rsapi.controller;

import ma.wafaassurance.rsapi.model.Client;
import ma.wafaassurance.rsapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/count")
    public long getClientCount() {
        return clientService.getClientCount();
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client saveClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        Optional<Client> client = Optional.ofNullable(clientService.getClientById(id));
        if (client.isPresent()) {
            Client updatedClient = client.get();
            updatedClient.setNom(clientDetails.getNom());
            updatedClient.setPrenom(clientDetails.getPrenom());
            updatedClient.setPhone(clientDetails.getPhone());
            updatedClient.setEmail(clientDetails.getEmail());
            updatedClient.setPassword(clientDetails.getPassword());
            updatedClient.setAdresse(clientDetails.getAdresse());
            updatedClient.setVille(clientDetails.getVille());
            updatedClient.setCodePostal(clientDetails.getCodePostal());
            updatedClient.setCin(clientDetails.getCin());
            updatedClient.setValide(clientDetails.getValide());
            return ResponseEntity.ok(clientService.saveClient(updatedClient));
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
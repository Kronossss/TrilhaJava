package com.leilao.leilao.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.leilao.leilao.controller.DTO.LanceDTO;
import com.leilao.leilao.controller.form.LanceFORM;
import com.leilao.leilao.model.Concorrente;
import com.leilao.leilao.model.Leilao;
import com.leilao.leilao.repository.ConcorrenteRepository;
import com.leilao.leilao.repository.LanceRepository;
import com.leilao.leilao.repository.LeilaoRepository;


@RestController
@RequestMapping("/lance/")
public class Lance {


    @Autowired
    private LanceRepository lanceRepository;


    @Autowired
    private LeilaoRepository leilaoRepository;


	@Autowired
	private ConcorrenteRepository concorrenteRepository;


    @GetMapping
    public ResponseEntity<List<LanceDTO>> getAllLances() {
        List<LanceDTO> lancesDTO = lanceRepository.findAll().stream().map(LanceDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(lancesDTO);
    }
    


    @GetMapping("/{id}")
    public ResponseEntity<?> getLanceById(@PathVariable Long id , UriComponentsBuilder uriBuilder) {
        try {
            com.leilao.leilao.model.Lance lance = lanceRepository.getReferenceById(id);
            LanceDTO lanceDTO = new LanceDTO(lance);
			return ResponseEntity.ok(lanceDTO);
        }catch(Exception e) {
			return ResponseEntity.notFound().build();
        }

    }


    @GetMapping("/leilao={leilaoId}")
    public ResponseEntity<?> getLancesByLeilaoId(@PathVariable Long leilaoId) {
        List<com.leilao.leilao.model.Lance> lances = lanceRepository.findByLeilaoId(leilaoId);
        if (lances.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<LanceDTO> lancesDTO = lances.stream().map(LanceDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(lancesDTO);
    }


    @GetMapping("/concorrente={concorrenteId}")
    public ResponseEntity<?> getLancesByConcorrenteId(@PathVariable Long concorrenteId) {
        List<com.leilao.leilao.model.Lance> lances = lanceRepository.findByConcorrenteId(concorrenteId);
        if (lances.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<LanceDTO> lancesDTO = lances.stream().map(LanceDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(lancesDTO);
    }



    @PostMapping
    public ResponseEntity<?> criarLance(@RequestBody LanceFORM lanceForm) {

    	Optional<Concorrente> concorrenteOptional = concorrenteRepository.findById(lanceForm.getConcorrenteId());
        if (concorrenteOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("O ID do concorrente fornecido não existe.");
        }
        

        Concorrente concorrente = concorrenteOptional.get();


        Optional<Leilao> leilaoOptional = leilaoRepository.findById(lanceForm.getLeilaoId());
        if (leilaoOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("O ID do leilão fornecido não existe.");
        }
        

        Leilao leilao = leilaoOptional.get();


        if (!leilao.getStatus()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("O leilão referido está fechado.");
        }
        
        if(lanceForm.getValor().compareTo(leilao.getValorMinimo()) < 0) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("O valor de lance foi abaixo do valor minimo.");
        }
        


        com.leilao.leilao.model.Lance lance = new com.leilao.leilao.model.Lance();
        lance.setConcorrente(concorrente);
        lance.setLeilao(leilao);
        lance.setValor(lanceForm.getValor());


        lanceRepository.save(lance);


        LanceDTO lanceDTO = new LanceDTO(lance);
        return ResponseEntity.status(HttpStatus.CREATED).body(lanceDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarLance(@PathVariable Long id, @RequestBody LanceFORM lanceForm) {
        try {

        	Optional<com.leilao.leilao.model.Lance> lanceOptional = lanceRepository.findById(id);
            if (lanceOptional.isEmpty()) {
                return ResponseEntity.notFound().build();
            }


            com.leilao.leilao.model.Lance lance = lanceOptional.get();


            Optional<Concorrente> concorrenteOptional = concorrenteRepository.findById(lanceForm.getConcorrenteId());
            if (concorrenteOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("O ID do concorrente fornecido não existe.");
            }


            Optional<Leilao> leilaoOptional = leilaoRepository.findById(lanceForm.getLeilaoId());
            if (leilaoOptional.isEmpty()) {
                return ResponseEntity.badRequest().body("O ID do leilão fornecido não existe.");
            }

            Leilao leilao = leilaoOptional.get();
            if (!leilao.getStatus()) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("O leilão referido está fechado.");
            }
            
            if(lanceForm.getValor().compareTo(leilao.getValorMinimo()) < 0) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("O valor de lance foi abaixo do valor minimo.");
            }

            lance.setConcorrente(concorrenteOptional.get());
            lance.setLeilao(leilao);
            lance.setValor(lanceForm.getValor());

            lanceRepository.save(lance);

            LanceDTO lanceDTO = new LanceDTO(lance);
            return ResponseEntity.ok(lanceDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLance(@PathVariable Long id) {
        try {

        	Optional<com.leilao.leilao.model.Lance> lanceOptional = lanceRepository.findById(id);
            if (lanceOptional.isEmpty()) {
                return ResponseEntity.notFound().build();
            }


            com.leilao.leilao.model.Lance lance = lanceOptional.get();

            Leilao leilao = lance.getLeilao();
            if (!leilao.getStatus()) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("O leilão referido está fechado.");
            }

            lanceRepository.delete(lance);

            LanceDTO lanceDTO = new LanceDTO(lance);
            return ResponseEntity.ok(lanceDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }





    
}

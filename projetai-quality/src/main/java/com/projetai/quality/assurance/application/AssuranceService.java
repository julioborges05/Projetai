package com.projetai.quality.assurance.application;

import com.projetai.development.utils.exceptions.UserNotFoundException;
import com.projetai.quality.assurance.application.dto.AssuranceDto;
import com.projetai.quality.assurance.domain.assurance.Assurance;
import com.projetai.quality.assurance.domain.assurance.status.AssuranceStatus;
import com.projetai.quality.assurance.infra.assurance.AssuranceEntity;
import com.projetai.quality.assurance.infra.assurance.AssuranceRepository;
import com.projetai.core.infra.user.developer.DeveloperEntity;
import com.projetai.core.infra.user.developer.DeveloperRepository;
import com.projetai.core.infra.user.support.SupportEntity;
import com.projetai.core.infra.user.support.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssuranceService {
    private final AssuranceRepository assuranceRepository;
    private final SupportRepository supportRepository;
    private final DeveloperRepository developerRepository;

    @Autowired
    public AssuranceService(AssuranceRepository assuranceRepository, SupportRepository supportRepository, DeveloperRepository developerRepository){
        this.assuranceRepository = assuranceRepository;
        this.supportRepository = supportRepository;
        this.developerRepository = developerRepository;
    }

    public AssuranceEntity findAssurance(Long id) throws Exception{
        Optional<AssuranceEntity> assurance = assuranceRepository.findById(id);
        if(assurance.isEmpty()){
            throw new Exception("Assurance not found");
        }

        return assurance.get();
    }

    public Page<AssuranceDto> findAllAssurance(Pageable pageable){
        return assuranceRepository.findAll(pageable).map(AssuranceDto::new);
    }

    public void startAssurance(AssuranceDto assuranceDto) {
        Optional<SupportEntity> supportEntity = supportRepository.findById(assuranceDto.supportId());
        Optional<DeveloperEntity> developerEntity = developerRepository.findById(assuranceDto.developerId());
        if(supportEntity.isEmpty() || developerEntity.isEmpty()){
            throw new UserNotFoundException("User not found");
        }

        Assurance assurance = new Assurance(assuranceDto.id(), assuranceDto.title(), assuranceDto.message(), AssuranceStatus.ON_HOLD, developerEntity.get(), supportEntity.get());
        assuranceRepository.save(assurance.startAssurance());
    }

    public void necessaryAdjustmentsAssurance(AssuranceDto assuranceDto) {
        Optional<AssuranceEntity> assuranceEntityOptional = assuranceRepository.findById(assuranceDto.id());
        if(assuranceEntityOptional.isEmpty()){
            throw new UserNotFoundException("Assurance not found");
        }

        AssuranceEntity assuranceEntity = assuranceEntityOptional.get();
        assuranceEntity.setMessage(assuranceDto.message());
        assuranceEntity.setStatus(AssuranceStatus.TODO);
        assuranceRepository.save(assuranceEntity);
    }

    public void completeAssurance(AssuranceDto assuranceDto) {
        Optional<AssuranceEntity> assuranceEntityOptional = assuranceRepository.findById(assuranceDto.id());
        if(assuranceEntityOptional.isEmpty()){
            throw new UserNotFoundException("Assurance not found");
        }

        AssuranceEntity assuranceEntity = assuranceEntityOptional.get();
        assuranceEntity.setMessage(assuranceDto.message());
        assuranceEntity.setStatus(AssuranceStatus.FINISHED);
        assuranceRepository.save(assuranceEntity);
    }
}

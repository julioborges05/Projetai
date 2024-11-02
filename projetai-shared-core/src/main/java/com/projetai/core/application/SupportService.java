package com.projetai.core.application;

import com.projetai.core.application.dto.SupportDto;
import com.projetai.core.domain.user.support.Support;
import com.projetai.core.infra.user.support.SupportEntity;
import com.projetai.core.infra.user.support.SupportRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupportService {

    private final SupportRepository supportRepository;

    @Autowired
    public SupportService(SupportRepository supportRepository) {
        this.supportRepository = supportRepository;
    }

    public List<SupportDto> findAllSupports() {
        return supportRepository.findAll()
                .stream()
                .map(Support::dbEntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public SupportDto createSupport(SupportDto supportDto) {
        SupportEntity support = new SupportEntity(supportDto);
        support.setId(null);

        return Support.dbEntityToDto(supportRepository.save(support));
    }

}

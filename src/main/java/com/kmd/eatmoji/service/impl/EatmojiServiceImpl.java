package com.kmd.eatmoji.service.impl;

import com.kmd.eatmoji.dto.EatmojiDTO;
import com.kmd.eatmoji.exception.ResourceNotFoundException;
import com.kmd.eatmoji.models.Eatmoji;
import com.kmd.eatmoji.repository.EatmojiRepository;
import com.kmd.eatmoji.service.EatmojiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EatmojiServiceImpl implements EatmojiService {

    private final EatmojiRepository eatmojiRepository;

    @Autowired
    public EatmojiServiceImpl(EatmojiRepository eatmojiRepository) {
        this.eatmojiRepository = eatmojiRepository;
    }

    @Override
    public EatmojiDTO findById(Long id) {

        Eatmoji eatmoji = this.eatmojiRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return new EatmojiDTO(eatmoji);
    }

    @Override
    public List<EatmojiDTO> findAll() {
        return this.eatmojiRepository
                .findAll()
                .stream()
                .map(eatmoji -> new EatmojiDTO(eatmoji))
                .collect(Collectors.toList());
    }

    @Override
    public EatmojiDTO convertAndSave(EatmojiDTO eatmojiDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}

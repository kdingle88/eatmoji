package com.kmd.eatmoji.service;


import com.kmd.eatmoji.dto.EatmojiDTO;
import com.kmd.eatmoji.models.Eatmoji;

import java.util.List;

public interface EatmojiService {

    EatmojiDTO findById(Long id);

    List<EatmojiDTO> getUserEatmojis(String username);

    List<EatmojiDTO> findAll();

    EatmojiDTO convertAndSave(EatmojiDTO eatmojiDTO);

    void deleteById(Long id);

}

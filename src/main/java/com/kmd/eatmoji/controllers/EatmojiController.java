package com.kmd.eatmoji.controllers;

import com.kmd.eatmoji.dto.EatmojiDTO;
import com.kmd.eatmoji.models.Eatmoji;
import com.kmd.eatmoji.models.User;
import com.kmd.eatmoji.service.EatmojiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "api/v1/eatmojis")
@RestController
public class EatmojiController {

    private final EatmojiService eatmojiService;

    @Autowired
    public EatmojiController(EatmojiService eatmojiService) {
        this.eatmojiService = eatmojiService;
    }

    @GetMapping
    public List<EatmojiDTO> findAll() {
        return this.eatmojiService.findAll();
    }

    @GetMapping("{id}")
    public EatmojiDTO findById(@PathVariable Long id) {


        return this.eatmojiService.findById(id);
    }
}


// Post Mapping eatmojis..will get a request.body
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<EatmojiDTO>> saveEatmojis(@RequestParam(required = false) Long id) {

//    }


// Probably will remove this
//    private Eatmoji eatmojiDtoToEntity(EatmojiDTO eatmojiDTO) {
//        Eatmoji eatmoji = new Eatmoji();
//
//        eatmoji.setId(eatmojiDTO.getId());
//        eatmoji.setName(eatmojiDTO.getName());
//        eatmoji.setImageUrl(eatmojiDTO.getImageUrl());
//        eatmoji.setCreatedOn(eatmojiDTO.getCreatedOn());
//        eatmoji.setModifiedOn(eatmojiDTO.getModifiedOn());
//        eatmoji.setUser(userService.getUserById(eatmojiDTO.getUser()));
//
//        return eatmoji;
//    }



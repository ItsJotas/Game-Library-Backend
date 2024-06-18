package com.example.gameLibrary.model.dto.update;

import com.example.gameLibrary.model.enums.GameFinishedEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameUpdateDTO {

    //TODO: exception for duplicated name
    private String name;
    private String imageUrl;

    //TODO: exception for duplicated image
    private String platform;
    private GameFinishedEnum gameFinishedEnum;
}

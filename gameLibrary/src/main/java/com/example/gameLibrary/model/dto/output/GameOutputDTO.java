package com.example.gameLibrary.model.dto.output;

import com.example.gameLibrary.model.enums.GameFinishedEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameOutputDTO {

    private String name;
    private String imageUrl;
    private String platform;
    private GameFinishedEnum gameFinishedEnum;
}

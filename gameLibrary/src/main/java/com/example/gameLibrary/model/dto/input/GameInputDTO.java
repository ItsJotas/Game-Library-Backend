package com.example.gameLibrary.model.dto.input;

import com.example.gameLibrary.model.enums.GameFinishedEnum;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameInputDTO {

    @NotNull(message = "The field 'Name' is required!")
    @NotBlank(message = "The field 'Name' cannot be empty!")
    @NotEmpty(message = "The field 'Name' cannot be empty!")
    private String name;

    @NotNull(message = "The field 'Image Url' is required!")
    @NotBlank(message = "The field 'Image Url' cannot be empty!")
    private String imageUrl;

    @NotNull(message = "The field 'Platform' is required!")
    @NotBlank(message = "The field 'Platform' cannot be empty!")
    private String platform;

    @NotNull(message = "The field 'Game Finished' is required!")
    private GameFinishedEnum gameFinishedEnum;
}

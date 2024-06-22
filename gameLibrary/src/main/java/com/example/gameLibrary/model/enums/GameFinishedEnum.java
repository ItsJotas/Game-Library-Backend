package com.example.gameLibrary.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameFinishedEnum {

    NO("No"),
    YES("Yes");

    private String description;
}

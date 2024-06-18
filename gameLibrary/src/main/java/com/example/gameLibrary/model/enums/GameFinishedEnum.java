package com.example.gameLibrary.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameFinishedEnum {

    NO("No"),
    Yes("Yes");

    private String description;
}

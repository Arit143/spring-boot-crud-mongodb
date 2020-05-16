package com.aritra.crud.controller.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class Message {
    private HttpStatus status;
    private String message;

    public static Message getInsertMessage() {
        return new Message(HttpStatus.OK, "Data successfully inserted");
    }

    public static Message getUpdateMessage() {
        return new Message(HttpStatus.OK, "Data successfully updated");
    }

    public static Message getDeleteMessage() {
        return new Message(HttpStatus.OK, "Data successfully deleted");
    }
}

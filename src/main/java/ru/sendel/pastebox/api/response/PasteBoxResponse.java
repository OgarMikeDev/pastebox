package ru.sendel.pastebox.api.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.sendel.pastebox.api.request.PublicStatus;

@Data
@RequiredArgsConstructor
public class PasteBoxResponse {
    private final String data;

    private final boolean isPublic;
}

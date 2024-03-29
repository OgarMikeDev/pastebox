package ru.sendel.pastebox;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.sendel.pastebox.api.response.PasteBoxResponse;
import ru.sendel.pastebox.exception.NotFoundEntityException;
import ru.sendel.pastebox.repository.PasteBoxEntity;
import ru.sendel.pastebox.repository.PasteBoxRepository;
import ru.sendel.pastebox.service.PasteBoxService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PasteBoxServiceTest {
    @Autowired
    private PasteBoxService pasteBoxService;

    @MockBean
    private PasteBoxRepository pasteBoxRepository;

    @Test
    public void notExistHash() {
        when(pasteBoxRepository.getByHash(anyString()))
                .thenThrow(NotFoundEntityException.class);

        assertThrows(NotFoundEntityException.class,
                () -> pasteBoxService.getByHash("clear"));
    }

    @Test
    public void getExistHash() {
        PasteBoxEntity entity = new PasteBoxEntity();
        entity.setHash("1");
        entity.setData("08");
        entity.setPublic(true);


        when(pasteBoxRepository.getByHash("1"))
                .thenReturn(entity);

        PasteBoxResponse expected = new PasteBoxResponse("08", true);
        PasteBoxResponse actual = pasteBoxService.getByHash("1");

        assertEquals(expected, actual);
    }
}

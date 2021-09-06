package training360.guinessapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/recorders")
public class RecordersController {

    private final GuinnessService service;

    public RecordersController(GuinnessService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecorderDto createRecorder(@Valid @RequestBody RecorderCreateCommand command) {
        return service.createRecorder(command);
    }

    @GetMapping("/api/recorder")
    @ResponseStatus(HttpStatus.CREATED)
    public List<RecorderShortDto> listAllRecorders() {
        return service.listAllRecorders();
    }




}

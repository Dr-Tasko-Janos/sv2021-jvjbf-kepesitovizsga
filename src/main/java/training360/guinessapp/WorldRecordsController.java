package training360.guinessapp;

import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;

@RestController
@RequestMapping("/api/worldrecords")
public class WorldRecordsController {

   public final GuinnessService service;

    public WorldRecordsController(GuinnessService service) {
        this.service = service;
    }

    @PostMapping
    public WorldRecordDto createWorldRecord(@RequestBody WorldRecordCreateCommand command) {
        return service.createWorldRecord(command);
    }

    @PutMapping("/{id}/beatrecords")



}

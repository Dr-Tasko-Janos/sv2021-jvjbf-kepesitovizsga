package training360.guinessapp;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuinnessService {

    private final GuinnessRepository repository;

    private final ModelMapper modelMapper;


    public RecorderDto createRecorder(RecorderCreateCommand command) {
        Recorder newRecorder = new Recorder(command.getName(), command.getDateOfBirth());
        repository.save(newRecorder);
        return modelMapper.map(newRecorder, RecorderDto.class);
    }

    public List<RecorderShortDto> listAllRecorders() {
        List<String> allRecorders = repository.findAll().stream().map(entity -> entity.getName()).collect(Collectors.toList());

        Type targetTypeList = new TypeToken<List<RecorderShortDto>>() {
        }.getType();

        return modelMapper.map(allRecorders, targetTypeList);
    }

    public WorldRecordDto createWorldRecord(WorldRecordCreateCommand command) {
        Recorder foundRecorder = repository.findById(command.getRecorderId()).orElseThrow(() -> new IllegalArgumentException("Recorder not found with id" + command.getRecorderId()));

        WorldRecord newWorldrecord = new WorldRecord(command.getDescription(), command.getValue(),
                command.getUnitOfMeasure(), command.getDateOfRecord(), foundRecorder.getRecorderId());
        repository.save(newWorldrecord);
    }
}

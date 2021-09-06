package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecorderCreateCommand {

    @NotNull
    @NotBlank(message = "must not be blank")
    @NotEmpty
    private String name;

    @NotNull
    @Past(message = "must be in the past")
    private LocalDate dateOfBirth;
}

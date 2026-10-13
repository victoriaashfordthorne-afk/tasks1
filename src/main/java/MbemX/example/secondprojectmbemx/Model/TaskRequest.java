package MbemX.example.secondprojectmbemx.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskRequest(
        @NotBlank(message = "Le titre est obligatoire")
        @Size(max = 120, message = "Le titre ne doit pas depasser 120 caracteres")
        String title,

        @Size(max = 500, message = "La description ne doit pas depasser 500 caracteres")
        String description,

        Boolean done
) {
}

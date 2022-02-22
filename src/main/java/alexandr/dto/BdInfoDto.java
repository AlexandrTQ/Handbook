package alexandr.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class BdInfoDto {
    private final int count;
    private final LocalDateTime firstCreate;
    private final LocalDateTime lastCreate;
}

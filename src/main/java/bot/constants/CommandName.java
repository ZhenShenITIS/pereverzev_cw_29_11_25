package bot.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CommandName {
    QUIT("/quit"),
    EXCHANGE("/exchange"),
    WEATHER("/weather"),
    LIST("/list");
    private final String value;
}

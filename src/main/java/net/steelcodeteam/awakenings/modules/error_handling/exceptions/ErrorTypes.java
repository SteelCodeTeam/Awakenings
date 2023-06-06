package net.steelcodeteam.awakenings.modules.error_handling.exceptions;

import java.io.Serializable;

public enum ErrorTypes implements Serializable {


    INDETERMINATE_ERROR("9999", "Unknown error, please, contact us in https://github.com/SteelCodeTeam/Awakenings/issues", SeverityType.ERROR),
    PLAYER_ERROR("1000", "Player is null or not found.", SeverityType.WARN),
    PLAYER_CAPABILITY_ERROR("1001", "Capability not found for a Player or ServerPlayer.", SeverityType.ERROR),
    PLAYER_DEAD_ERROR("1002", "Player is dead error.", SeverityType.WARN),
    ELEVATION_INDETERMINATE("2001", "Elevation not found. Re-assign new Elevation", SeverityType.WARN);


    private final String code;
    private final String message;
    private final SeverityType severity;

    /**
     * Constructor that initializes the error type with the provided code, message, and severity.
     *
     * @param code     the unique error code
     * @param message  the descriptive error message
     * @param severity the severity level of the error
     */
    ErrorTypes(String code, String message, SeverityType severity) {
        this.code = code;
        this.message = message;
        this.severity = severity;
    }

    /**
     * Getter method for the error code.
     *
     * @return the unique error code associated with the error type
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Getter method for the error message.
     *
     * @return the descriptive error message associated with the error type
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Getter method for the severity type.
     *
     * @return the severity level associated with the error type
     */
    public SeverityType getSeverityType() {
        return this.severity;
    }

}

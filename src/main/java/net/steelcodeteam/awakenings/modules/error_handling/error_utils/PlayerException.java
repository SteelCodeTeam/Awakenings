package net.steelcodeteam.awakenings.modules.error_handling.error_utils;

import net.minecraftforge.common.util.NonNullSupplier;
import net.steelcodeteam.awakenings.modules.error_handling.exceptions.ErrorTypes;
import net.steelcodeteam.awakenings.modules.error_handling.exceptions.SeverityType;
import net.steelcodeteam.awakenings.modules.error_handling.messages.LoggerUtils;
import org.jetbrains.annotations.NotNull;

public class PlayerException extends Exception implements NonNullSupplier<PlayerException> {

    private final ErrorTypes errorType;

    public PlayerException(ErrorTypes errorType) {
        super();
        this.errorType = errorType;
    }

    public ErrorTypes getErrorType() {
        return errorType;
    }

    public String getMessage() {
        return  this.errorType.getMessage();
    }

    public String getCode() {
        return this.errorType.getCode();
    }
    public SeverityType getSeverityType() {
        return this.errorType.getSeverityType();
    }
    public void printResumeLog() {
        LoggerUtils.printLog(this.getCode(), this.getMessage(), null, this.getSeverityType());
    }

    /**
     * Prints a complete log of the exception, including the error code, message, stack trace, and severity type.
     */
    public void printCompleteLog() {
        LoggerUtils.printLog(this.getCode(), this.getMessage(), this.getStackTrace(), this.getSeverityType());
    }

    @NotNull
    @Override
    public PlayerException get() {
        return this;
    }
}

package Book.Reviews.Book.reviews.Response;

public class RegistrationResponse {
    private final String message;

    private final Boolean isSuccess;

    private final Long userId;

    public RegistrationResponse(String message, boolean isSuccess, Long userId) {
        this.message = message;
        this.isSuccess = isSuccess;
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public Long getUserId() {
        return userId;
    }
}

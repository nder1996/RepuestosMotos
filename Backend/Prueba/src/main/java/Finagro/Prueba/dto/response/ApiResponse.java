package Finagro.Prueba.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private Meta meta;
    private T data;
    private ErrorDetails error;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Meta {
        private String message;
        private Integer statusCode;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ErrorDetails {
        private String code;
        private String description;
    }
}

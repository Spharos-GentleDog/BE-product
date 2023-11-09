package egenius.product.global.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;


@Getter
@AllArgsConstructor
public enum BaseResponseStatus {

    /**
     * 200: 요청 성공
     **/
    SUCCESS(HttpStatus.OK,true, 200, "요청에 성공하였습니다."),

    /**
     * 900: 기타 에러
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, 900, "Internal server error"),

    // 상품 : 4000번대
    DISCOUNT_TYPE_NOT_FOUND(HttpStatus.NOT_FOUND, false, 4001, "존재하지 않는 할인 유형입니다"),
    SIZE_IS_NOT_FOUND(HttpStatus.NOT_FOUND, false, 4002, "존재하지 않는 사이즈입니다"),
    CREATE_SIZE_FAIL(HttpStatus.BAD_REQUEST, false, 4003, "사이즈 생성에 실패하였습니다"),
    COLOR_CODE_ERROR(HttpStatus.BAD_REQUEST, false, 4004, "헥스코드를 올바르게 입력해주세요"),
    ;
    private final HttpStatusCode httpStatusCode;
    private final boolean isSuccess;
    private final int code;
    private String message;
}

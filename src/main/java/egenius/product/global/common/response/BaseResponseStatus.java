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
    NOT_FOUND_CATEGORY(HttpStatus.NOT_FOUND, false, 4005, "존재하지 않는 카테고리입니다"),
    SALES_STATUS_IS_NOT_FOUND(HttpStatus.NOT_FOUND, false, 4006, "존재하지 않는 판매상태입니다"),
    DISPLAY_STATUS_IS_NOT_FOUND(HttpStatus.NOT_FOUND, false, 4007, "존재하지 않는 진열상태입니다"),
    NO_EXIST_PRODUCT(HttpStatus.NOT_FOUND, false, 4008, "존재하지 않는 상품입니다"),
    NOT_FOUND_CHILD_CATEGORY(HttpStatus.NOT_FOUND, false, 4009, "하위 카테고리가 존재하지 않습니다"),;


    private final HttpStatusCode httpStatusCode;
    private final boolean isSuccess;
    private final int code;
    private String message;
}

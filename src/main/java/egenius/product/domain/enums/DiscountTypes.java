package egenius.product.domain.enums;

import egenius.product.global.common.exception.BaseException;
import egenius.product.global.common.response.BaseResponseStatus;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum DiscountTypes {

    PERCENT(0,"퍼센트"),
    AMOUNT(1,"금액");

    private Integer codeValue;
    private String nameValue;

    DiscountTypes(Integer codeValue, String nameValue){
        this.codeValue = codeValue;
        this.nameValue = nameValue;
    }

    // codeValue를 통해 해당 enum을 찾는 메소드
    public static DiscountTypes ofCodeValue(Integer codeValue){

        return Arrays.stream(DiscountTypes.values())
                .filter(v->v.getCodeValue().equals(codeValue))
                .findAny()
                .orElseThrow(()-> new BaseException(BaseResponseStatus.DISCOUNT_TYPE_NOT_FOUND));
    }

    // NameValue를 통해 해당 enum을 찾는 메소드
    public static DiscountTypes ofNameValue(String nameValue){

        return Arrays.stream(DiscountTypes.values())
                .filter(v->v.getNameValue().equals(nameValue))
                .findAny()
                .orElseThrow(()-> new BaseException(BaseResponseStatus.DISCOUNT_TYPE_NOT_FOUND));
    }

}

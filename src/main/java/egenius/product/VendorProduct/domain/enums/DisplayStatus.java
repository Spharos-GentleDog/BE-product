package egenius.product.VendorProduct.domain.enums;

import egenius.product.global.common.exception.BaseException;
import egenius.product.global.common.response.BaseResponseStatus;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum DisplayStatus {

    DISPLAY(0, "진열"),
    NOT_DISPLAY(1, "진열중지");

    private Integer codeValue;
    private String nameValue;

    DisplayStatus(Integer codeValue, String nameValue) {
        this.codeValue = codeValue;
        this.nameValue = nameValue;
    }

    public static DisplayStatus ofCodeValue(Integer codeValue){

        return Arrays.stream(DisplayStatus.values())
                .filter(v->v.getCodeValue().equals(codeValue))
                .findAny()
                .orElseThrow(()-> new BaseException(BaseResponseStatus.DISPLAY_STATUS_IS_NOT_FOUND));
    }

    public static DisplayStatus ofNameValue(String nameValue){

        return Arrays.stream(DisplayStatus.values())
                .filter(v->v.getNameValue().equals(nameValue))
                .findAny()
                .orElseThrow(()-> new BaseException(BaseResponseStatus.DISPLAY_STATUS_IS_NOT_FOUND));
    }
}


package egenius.product.VendorProduct.domain.enums;

import egenius.product.global.common.exception.BaseException;
import egenius.product.global.common.response.BaseResponseStatus;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum SalesStatus {

    SALES(1, "판매중"),
    STOP_SALES(2, "판매중지"),
    SOLD_OUT(3, "품절");

    private Integer codeValue;
    private String nameValue;

    SalesStatus(Integer codeValue, String nameValue) {
        this.codeValue = codeValue;
        this.nameValue = nameValue;
    }

    public static SalesStatus ofCodeValue(Integer codeValue){

        return Arrays.stream(SalesStatus.values())
                .filter(v->v.getCodeValue().equals(codeValue))
                .findAny()
                .orElseThrow(()-> new BaseException(BaseResponseStatus.SALES_STATUS_IS_NOT_FOUND));
    }

    public static SalesStatus ofNameValue(String nameValue){

        return Arrays.stream(SalesStatus.values())
                .filter(v->v.getNameValue().equals(nameValue))
                .findAny()
                .orElseThrow(()-> new BaseException(BaseResponseStatus.SALES_STATUS_IS_NOT_FOUND));
    }
}

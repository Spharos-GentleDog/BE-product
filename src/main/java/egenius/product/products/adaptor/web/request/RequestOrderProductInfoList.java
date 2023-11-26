package egenius.product.products.adaptor.web.request;

import lombok.Getter;

import java.util.List;

@Getter
public class RequestOrderProductInfoList {

    private String brandName;
    private List<RequestOrderProductInfo> requestOrderProductInfoList;

}

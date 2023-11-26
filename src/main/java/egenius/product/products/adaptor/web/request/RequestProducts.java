package egenius.product.products.adaptor.web.request;

import jdk.dynalink.linker.LinkerServices;
import lombok.Getter;

import java.util.List;

@Getter
public class RequestProducts {

    private String brandName;
    private List<Long> productDetailIds;

}

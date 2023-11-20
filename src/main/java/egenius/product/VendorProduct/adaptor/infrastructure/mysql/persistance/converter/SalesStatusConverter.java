package egenius.product.VendorProduct.adaptor.infrastructure.mysql.persistance.converter;

import egenius.product.VendorProduct.domain.enums.SalesStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

@Converter
@Component
public class SalesStatusConverter implements AttributeConverter<SalesStatus,Integer> {


    @Override
    public Integer convertToDatabaseColumn(SalesStatus attribute) {
        return attribute.getCodeValue();
    }

    @Override
    public SalesStatus convertToEntityAttribute(Integer dbData) {
        return SalesStatus.ofCodeValue(dbData);
    }
}

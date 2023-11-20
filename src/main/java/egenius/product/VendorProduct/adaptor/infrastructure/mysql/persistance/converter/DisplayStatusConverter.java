package egenius.product.VendorProduct.adaptor.infrastructure.mysql.persistance.converter;

import egenius.product.VendorProduct.domain.enums.DisplayStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

@Converter
@Component
public class DisplayStatusConverter implements AttributeConverter<DisplayStatus,Integer> {
    @Override
    public Integer convertToDatabaseColumn(DisplayStatus attribute) {
        return attribute.getCodeValue();
    }

    @Override
    public DisplayStatus convertToEntityAttribute(Integer dbData) {
        return DisplayStatus.ofCodeValue(dbData);
    }
}
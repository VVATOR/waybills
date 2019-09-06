package com.gok.waybill.waybillservice.configuration;

import com.gok.waybill.waybillservice.data.dto.Dto;
import com.gok.waybill.waybillservice.data.model.Driver;
import com.gok.waybill.waybillservice.data.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertEquals;

@DisplayName("Mapping Dto To Driver:Model")
class ModelMapperConverterConfigurationTest {

    ModelMapperConverterConfiguration conf;

    @BeforeEach
    void setUp() {
        ModelMapper mapper = new ModelMapper();
        conf = new ModelMapperConverterConfiguration(mapper);
    }

    @Test
    @DisplayName("Mapping Dto To Model(Driver)")
    public void fieldDtoToModel() {
        Dto dto = new Dto(1, true);
        dto.setId(1);
        dto.setDeleted(true);
        Model model = new Driver();
        conf.fieldDtoToModel(dto, model);
        assertEquals(model.getId(), dto.getId());
        assertEquals(model.isDeleted(), dto.isDeleted());

    }

    @Test
    @DisplayName("Mapping Model(Driver) To Dto")
    public void fieldModelToDto() {
        Model model = new Driver();
        model.setId(1);
        model.setDeleted(true);

        Dto dto = new Dto(1, true);

        conf.fieldModelToDto(model, dto);
        assertEquals(dto.getId(), model.getId());
        assertEquals(dto.isDeleted(), model.isDeleted());
    }


}
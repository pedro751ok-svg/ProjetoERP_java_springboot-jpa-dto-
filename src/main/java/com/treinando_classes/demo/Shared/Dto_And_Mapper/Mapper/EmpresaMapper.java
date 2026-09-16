package com.treinando_classes.demo.Shared.Dto_And_Mapper.Mapper;

import com.treinando_classes.demo.Shared.Dto_And_Mapper.EmpresaDto;
import com.treinando_classes.demo.Shared.Empresa;
import org.mapstruct.Mapper;

public class EmpresaMapper {
    @Mapper(componentModel = "spring")
    public interface MapperEmpresa{
        EmpresaDto toDto(Empresa empresa);
        Empresa toEmpresa(EmpresaDto dto);
    }
}

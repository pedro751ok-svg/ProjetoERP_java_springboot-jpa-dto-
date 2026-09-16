package com.treinando_classes.demo.Shared.Dto_And_Mapper.Mapper;
import org.mapstruct.Mapper;
import com.treinando_classes.demo.Shared.Funcionario;
import com.treinando_classes.demo.Shared.Dto_And_Mapper.FuncionarioDTO;
public class FuncionarioMapper {
    @Mapper(componentModel = "spring")
    public interface MapperFuncionario{
        FuncionarioDTO toDto(Funcionario funcionario);
        Funcionario toFuncionario(FuncionarioDTO dto);
    }
}

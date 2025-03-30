package sit.kmutt.demo_exam2_int204.utils;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import sit.kmutt.demo_exam2_int204.dtos.PageDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ListMapper {

    private static final ListMapper listMapper = new ListMapper();

    private ListMapper() {
    }

    public <S, T> List<T> mapList(List<S> original, Class<T> targetClass, ModelMapper modelMapper) {
        return original.stream().map(originalItem -> modelMapper.map(originalItem, targetClass)).collect(Collectors.toList());
    }

    public static ListMapper getInstance() {
        return listMapper;
    }

    public <S, T> PageDTO<T> toPageDto(Page<S> original, Class<T> targetClass, ModelMapper modelMapper) {
        PageDTO<T> dto = modelMapper.map(original, PageDTO.class);
        dto.setContent(mapList(original.getContent(), targetClass, modelMapper));

        return dto;
    }
}

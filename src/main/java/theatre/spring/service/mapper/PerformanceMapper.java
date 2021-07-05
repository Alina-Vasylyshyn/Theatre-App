package theatre.spring.service.mapper;

import org.springframework.stereotype.Component;
import theatre.spring.dto.request.PerformanceRequestDto;
import theatre.spring.dto.response.PerformanceResponseDto;
import theatre.spring.model.Performance;

@Component
public class PerformanceMapper implements RequestDtoMapper<PerformanceRequestDto, Performance>,
        ResponseDtoMapper<PerformanceResponseDto, Performance> {
    @Override
    public Performance mapToModel(PerformanceRequestDto dto) {
        Performance movie = new Performance();
        movie.setTitle(dto.getPerformanceTitle());
        movie.setDescription(dto.getPerformanceDescription());
        return movie;
    }

    @Override
    public PerformanceResponseDto mapToDto(Performance movie) {
        PerformanceResponseDto responseDto = new PerformanceResponseDto();
        responseDto.setPerformanceId(movie.getId());
        responseDto.setPerformanceTitle(movie.getTitle());
        responseDto.setPerformanceDescription(movie.getDescription());
        return responseDto;
    }
}
